package engine.viewable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.PrintStream;


/**
 * The engine viewable object. This singleton class manages the typical viewable object state, whether it be for a full
 * screen view or a windowed application form.
 * @author Gregory
 * @see #instance instance
 * @see #viewable viewable
 * @see #fullscreen fullscreen
 * @see #EngineViewable() EngineViewable()
 * @see #getViewableGraphics2D() getViewableGraphics2D()
 * @see #toggleViewable(int,int,String) toggleViewable(int,int,String)
 */
public class EngineViewable {
  /**
   * The default {@link EngineViewable} instance.
   * @see EngineViewable
   */
  public static final EngineViewable instance;
  /**
   * The global output stream. This takes the {@link System.out} object and creates an output object.
   * @see EngineViewable
   */
  public static final PrintStream output;

  static {
    instance = new EngineViewable();
    output = new PrintStream(System.out, true);
  }

  /**
   * The viewable object.
   * @see EngineViewable
   */
  private Viewable viewable = null;
  /**
   * Is the viewable object full-screen. Initializes as {@code false}.
   * @see EngineViewable
   */
  private boolean fullscreen = false;

  /**
   * A private constructor. This does nothing, goes nowhere.
   * @see EngineViewable
   */
  private EngineViewable() {
  }

  /**
   * Get the graphics context. This supplies a {@code Graphics2D} context for use in the engine, for rendering things.
   * @return A {@link Graphics2D} object.
   * @see EngineViewable
   */
  public final Graphics2D getViewableGraphics2D() {
    return viewable.getGraphics2D();
  }

  public final void fillRect() {
    if(viewable != null) {
      viewable.getGraphics2D().setColor(Color.black);
      viewable.getGraphics2D().fillRect(0, 0, viewable.sizeWidth, viewable.sizeHeight);
    }
  }

  /**
   * Toggle a viewable object state. The "toggle" state is either full-screen or windowed.
   * @param i An {@link Integer} value, representing the viewable width.
   * @param j An {@link Integer} value, representing the viewable height.
   * @param s A {@link String} object, representing a game title.
   * @see EngineViewable
   */
  public synchronized final void toggleViewable(int i, int j, String s) {
    if(viewable != null) {
      viewable = null;
    }
    viewable = fullscreen
        ? new ViewableFullscreen(i, j, s)
        : new ViewableWindowable(i, j, s);
    fullscreen = !fullscreen;
  }
}
