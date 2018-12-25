import java.io.File;
import java.io.IOException;

/**
 * @author loodeer
 * @date 2018-12-26 00:10
 */
public class QrcodeExercise {
    public static void main(String[] args) throws IOException {
        // 项目根目录下
        File f = new File("qrcode.png");
        QRCodeUtil.qrCodeEncode("https://www.baidu.com/s?哈哈哈", f);

        String s = QRCodeUtil.qrCodeDecode(f);
        System.out.println("解码内容为：" + s);
    }
}
