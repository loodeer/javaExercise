import java.io.File;
import java.io.IOException;

/**
 * @author loodeer
 * @date 2018-12-26 00:10
 */
public class QrcodeExercise {
    public static void main(String[] args) throws IOException {
        File f = new File(".");
        QRCodeUtil.qrCodeEncode("http://baidu.com", f);
    }
}
