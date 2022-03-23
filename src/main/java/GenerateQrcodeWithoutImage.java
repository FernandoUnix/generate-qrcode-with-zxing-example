import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GenerateQrcodeWithoutImage {

  public void execute(BufferedImage qrImage) throws IOException {

    BufferedImage bufferedImage = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
    Graphics2D g = (Graphics2D) bufferedImage.getGraphics();

    g.drawImage(qrImage, 0, 0, null);

    ImageIO.write(bufferedImage, "png", new File("qrcode_without_img.png"));
  }
}