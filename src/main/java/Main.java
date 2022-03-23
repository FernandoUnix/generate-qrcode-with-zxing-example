import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class Main {

  public static void main(String[] args) {

    Map hints = new HashMap();
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);

    try {
      // Create a qr code with the url as content and a size of 250x250 px
      BitMatrix bitMatrix = new QRCodeWriter().encode(QrCodeConst.CONTENT_QR_CODE, BarcodeFormat.QR_CODE, QrCodeConst.WIDTH, QrCodeConst.HEIGHT, hints);
      MatrixToImageConfig config = new MatrixToImageConfig(MatrixToImageConfig.BLACK, MatrixToImageConfig.WHITE);
      // Load QR image
      BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, config);

      new GenerateQrcodeWithoutImage().execute(qrImage);
      new GenerateQrcodeWithText().execute(qrImage);
      new GenerateQrcodeWithImage().execute(qrImage);

      System.out.println("Finished");

    } catch (Exception e) {
      System.out.println(e);
    }
  }
}