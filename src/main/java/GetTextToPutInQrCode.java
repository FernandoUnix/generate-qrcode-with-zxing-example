import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GetTextToPutInQrCode {

  private final GetSquareToPutInTheCenterOfQrCode getSquareToPutInTheCenterOfQrCode;

  public GetTextToPutInQrCode(){
    this.getSquareToPutInTheCenterOfQrCode = new GetSquareToPutInTheCenterOfQrCode();
  }

  public BufferedImage execute() throws IOException {

    BufferedImage image = getSquareToPutInTheCenterOfQrCode.execute();

    Graphics2D g = (Graphics2D) image.getGraphics();

    Font font = new Font("Arial", Font.BOLD, 14);
    g.setFont(font);
    g.setColor(Color.PINK);
    g.drawString("Hello World", 0, (int) Math.round(QrCodeConst.HEIGHT_CENTER / 2) );
    g.dispose();
    return image;
  }
}