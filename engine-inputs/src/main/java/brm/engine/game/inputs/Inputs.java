package brm.engine.game.inputs;
import brm.engine.game.inputs.enums.InputLock;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;


public class Inputs implements KeyListener {
  private static List<InputLock> inputLock;
  private static boolean inputPaused = false;

  protected static KeyEvent MOVE_DASH;

  public static final InputHandler input;
  public static final Key up;
  public static final Key down;
  public static final Key left;
  public static final Key right;
  public static final Key confirm;
  public static final Key escape;
  public static final Key fps;

  static {
    MOVE_DASH = null;

    input = new InputHandler();
    up = new Key();
    down = new Key();
    left = new Key();
    right = new Key();
    confirm = new Key();
    escape = new Key();
    fps = new Key();
  }

  public Inputs() {
  }

  //==============================================================================
  // The "KeyListener" methods...

  @Override
  public final void keyPressed(KeyEvent e) {
  }

  @Override
  public final void keyReleased(KeyEvent e) {
  }

  @Override
  public final void keyTyped(KeyEvent e) {
  }

  //==============================================================================

  public static final boolean isInputLockEmpty() {
    return inputLock.isEmpty();
  }

  public static final boolean isInputPaused() {
    return inputPaused;
  }

  public static final void addInputLock(InputLock il) {
    if(!inputLock.contains(il)) {
      inputLock.add(il);
    }
  }

  public static final void delInputLock(InputLock il) {
    inputLock.remove(il);
  }

  public static final void setInputPaused(boolean b) {
    inputPaused = b;
  }
}
