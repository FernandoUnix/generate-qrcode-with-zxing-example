import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GetLogoToAddToQrCode {

  public BufferedImage execute(String path) throws IOException {

    BufferedImage logoLoadedIntoMemory = ImageIO.read(new File(path));

    int newWidth = 60;
    int newHeight = QrCodeConst.HEIGHT/6;

    BufferedImage logoBufferedImageWithNewSize = new BufferedImage(newWidth, newHeight, logoLoadedIntoMemory.getType());

    Graphics2D graphics2DForNewLogo = logoBufferedImageWithNewSize.createGraphics();

    graphics2DForNewLogo.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    graphics2DForNewLogo.drawImage(logoLoadedIntoMemory, 0, 0, newWidth, newHeight, 0, 0, logoLoadedIntoMemory.getWidth(), logoLoadedIntoMemory.getHeight(), null);
    graphics2DForNewLogo.dispose();

    return logoBufferedImageWithNewSize;
  }
}