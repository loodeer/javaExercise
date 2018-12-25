import com.swetake.util.Qrcode;
import jp.sourceforge.qrcode.QRCodeDecoder;
import jp.sourceforge.qrcode.data.QRCodeImage;
import jp.sourceforge.qrcode.exception.DecodingFailedException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author loodeer
 * @date 2018-12-25 23:56
 */
public class QRCodeUtil {

    public static void qrCodeEncode(String encodeData, File destFile) throws IOException {
        Qrcode qrcode = new Qrcode();
        // 纠错级别 (L 7%, M 15%, Q 25%, H 30%) 和版本有关
        qrcode.setQrcodeErrorCorrect('M');
        qrcode.setQrcodeEncodeMode('B');
        // 设置 Qrcode 包的版本
        qrcode.setQrcodeVersion(7);

        byte[] d = encodeData.getBytes("UTF-8");
        BufferedImage bi = new BufferedImage(139, 139, BufferedImage.TYPE_INT_RGB);

        // 创建图层
        Graphics2D g = bi.createGraphics();
        // 设置背景颜色为白色
        g.setBackground(Color.WHITE);
        // 矩形
        g.clearRect(0, 0, 139, 139);
        // 设置图像颜色（黑色）
        g.setColor(Color.BLACK);

        if (d.length > 0 && d.length < 123){
            boolean[][] b = qrcode.calQrcode(d);
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < b.length; j++) {
                    if (b[j][i]){
                        g.fillRect(j*3+2,i*3+2,3,3);
                    }
                }
            }
        }

        // 中间的 logo, 这段有点问题 TODO
//        Image img = ImageIO.read(new File("src/main/iqrcode/logo.png"));
//        g.drawImage(img, 25,55,60,50, null);

        // 释放此图形的上下文一级它使用的所有系统资源。调用 dispose 之后就不能再使用 Graphics 对象
        g.dispose();
        // 刷新此 Image 对象正在使用的所有可重构的资源
        bi.flush();
        ImageIO.write(bi, "png", destFile);
        System.out.println("Inout Encode data is: " + encodeData);
    }

    /**
     * 解析二维码，返回解析内容
     *
     * @param imageFile
     * @return
     */
    public static String qrCodeDecode(File imageFile) {
        String decodedData = null;
        QRCodeDecoder decoder = new QRCodeDecoder();
        BufferedImage image = null;
        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            decodedData = new String(decoder.decode(new J2SEImage(image)), "UTF-8");
            //              System.out.println("Output Decoded Data is：" + decodedData);
        } catch (DecodingFailedException dfe) {
            System.out.println("Error: " + dfe.getMessage());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodedData;
    }

    static class J2SEImage implements QRCodeImage {
        BufferedImage image;

        public J2SEImage(BufferedImage image) {
            this.image = image;
        }

        @Override public int getWidth() {
            return image.getWidth();
        }

        @Override public int getHeight() {
            return image.getHeight();
        }

        @Override public int getPixel(int x, int y) {
            return image.getRGB(x, y);
        }
    }

}
