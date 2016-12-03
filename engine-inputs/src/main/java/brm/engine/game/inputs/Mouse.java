package brm.engine.game.inputs;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;


/**
 * The mouse listeners. This handles a mouse general listener, a mouse motion listener, and a mouse wheel listener.
 * @author Gregory
 */
public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
  private static transient int mouseX;
  private static transient int mouseY;
  private static transient int mouseB;

  //==============================================================================
  // The "MouseListener" methods...

  @Override
  public final void mouseClicked(MouseEvent e) {
    mouseX = e.getXOnScreen();
    mouseY = e.getYOnScreen();
    mouseB = e.getButton();
  }

  @Override
  public final void mousePressed(MouseEvent e) {
  }

  @Override
  public final void mouseReleased(MouseEvent e) {
  }

  @Override
  public final void mouseEntered(MouseEvent e) {
  }

  @Override
  public final void mouseExited(MouseEvent e) {
  }

  //==============================================================================
  // The "MouseMotionListener" methods...

  @Override
  public final void mouseDragged(MouseEvent e) {
  }

  @Override
  public final void mouseMoved(MouseEvent e) {
  }

  //==============================================================================
  // The "MouseWheelListener" methods...

  @Override
  public final void mouseWheelMoved(MouseWheelEvent e) {
  }

  //==============================================================================

  public static final int getMouseB() {
    return mouseB;
  }

  public static final int getMouseX() {
    return mouseX;
  }

  public static final int getMouseY() {
    return mouseY;
  }

  public static final void setMouseB(int i) {
    Mouse.mouseB = i;
  }

  public static final void setMouseX(int i) {
    Mouse.mouseX = i;
  }

  public static final void setMouseY(int i) {
    Mouse.mouseY = i;
  }
}
