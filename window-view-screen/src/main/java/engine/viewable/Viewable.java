package engine.viewable;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.image.BufferStrategy;


/**
 * A viewable object definition. This is the abstract parent class of windowed and framed views.
 * @author Gregory
 */
abstract public class Viewable {
  /**
   * The viewable title.
   * @see Viewable
   */
  protected final String title;
  /**
   * The viewable width.
   * @see Viewable
   */
  protected final int sizeWidth;
  /**
   * The viewable height.
   * @see Viewable
   */
  protected final int sizeHeight;

  /**
   * A protected constructor.
   * @see Viewable
   */
  protected Viewable(int i, int j, String s) {
    sizeWidth = i;
    sizeHeight = j;
    title = s;
  }

  /**
   * Get the buffer strategy.
   * @return A {@link BufferStrategy} object.
   * @see Viewable
   */
  abstract protected BufferStrategy getBufferStrategy();

  /**
   * Get the graphic context.
   * @return A {@link Graphics2D} object.
   * @see Viewable
   */
  abstract protected Graphics2D getGraphics2D();

  abstract protected Window getWindow();
}
