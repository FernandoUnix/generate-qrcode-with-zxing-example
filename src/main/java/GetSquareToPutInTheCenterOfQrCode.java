import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class GetSquareToPutInTheCenterOfQrCode {

  public BufferedImage execute(){

    int width = QrCodeConst.WIDTH_CENTER;
    //int height = HEIGHT/6;

    int height = QrCodeConst.HEIGHT_CENTER;

    BufferedImage image = new BufferedImage(width, height,
        BufferedImage.BITMASK);

    Graphics2D g = (Graphics2D) image.getGraphics();

    g.setColor(Color.WHITE);
    g.fillRect(0, 0, width, height);
    g.dispose();

    return image;
  }
}
