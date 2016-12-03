package brm.engine.game.inputs;
import java.awt.event.KeyEvent;


/**
 * A key object for input handling.
 * @author Gregory
 */
public class Key {
  public volatile boolean down; // is key held down?
  public volatile boolean pressed; // is key pressed?
  public volatile int absorbs;
  public volatile int presses;

  public Key() {
  }

  public synchronized void tick() {
    if(absorbs < presses) {
      absorbs++;
      pressed = true;
    } else {
      pressed = false;
    }
  }

  public synchronized void toggle(KeyEvent e, boolean pressed) {
    if(down != pressed) {
      down = pressed;
    }
    if(pressed) {
      presses++;
    }
  }
}
