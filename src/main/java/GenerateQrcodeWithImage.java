import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GenerateQrcodeWithImage {

  private final GetLogoToAddToQrCode getLogoToAddToQrCode;

  public GenerateQrcodeWithImage(){
    this.getLogoToAddToQrCode = new GetLogoToAddToQrCode();
  }

  public void execute(BufferedImage qrImage) throws IOException {

    BufferedImage logoImage = getLogoToAddToQrCode.execute("logo.png");

    // Calculate the delta height and width between QR code and logo

    int deltaHeight = qrImage.getHeight() - logoImage.getHeight();
    int deltaWidth = qrImage.getWidth() - logoImage.getWidth();

    // Initialize combined image
    BufferedImage combined = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = (Graphics2D) combined.getGraphics();
    // Write QR code to new image at position 0/0
    g.drawImage(qrImage, 0, 0, null);
    g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
    // Write logo into combine image at position (deltaWidth / 2) and
    // (deltaHeight / 2). Background: Left/Right and Top/Bottom must be
    // the same space for the logo to be centered
    g.drawImage(logoImage, (int) Math.round(deltaWidth / 2), (int) Math.round(deltaHeight / 2), null);
    // Write combined image as PNG to OutputStream
    ImageIO.write(combined, "png", new File("qrcode_with_img.png"));
  }
}