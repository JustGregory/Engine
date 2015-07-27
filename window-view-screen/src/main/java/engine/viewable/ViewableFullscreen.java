package engine.viewable;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.image.BufferStrategy;


/**
 * The full-screen viewable component.
 * @author Gregory
 */
public class ViewableFullscreen extends Viewable {
  private final GraphicsDevice defaultScreenDevice;
  private final GraphicsEnvironment graphicsEnvironment;
  private final Window window;

  public ViewableFullscreen(int i, int j, String s) {
    super(i, j, s);
    graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
    defaultScreenDevice = graphicsEnvironment.getDefaultScreenDevice();
    window = defaultScreenDevice.getFullScreenWindow();
  }

  @Override
  protected Graphics2D getGraphics2D() {
    return (Graphics2D)window.getGraphics();
  }

  @Override
  protected BufferStrategy getBufferStrategy() {
    return window.getBufferStrategy();
  }

  @Override
  protected Window getWindow() {
    return window;
  }
}
