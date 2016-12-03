package brm.engine.game.inputs;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;


/**
 * An input handler.
 * @author Gregory
 */
public class InputHandler implements KeyListener {
  public List<Key> keys;
  public Key up = new Key();
  public Key down = new Key();
  public Key left = new Key();
  public Key right = new Key();
  public Key confirm = new Key();
  public Key escape = new Key();
  public Key fps = new Key();

  public InputHandler() {
    keys = new ArrayList<>(0);
  }

  @Override
  public void keyPressed(KeyEvent e) {
    toggle(e, true);
  }

  @Override
  public void keyReleased(KeyEvent e) {
    toggle(e, false);
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }

  public void tick() {
    for(Key key : keys) {
      key.tick();
    }
  }

  private void toggle(KeyEvent e, boolean pressed) {
    int kc = e.getKeyCode();
    if(kc == KeyEvent.VK_W || kc == KeyEvent.VK_UP) {
      Inputs.up.toggle(e, pressed);
    }
    if(kc == KeyEvent.VK_A || kc == KeyEvent.VK_LEFT) {
      Inputs.left.toggle(e, pressed);
    }
    if(kc == KeyEvent.VK_S || kc == KeyEvent.VK_DOWN) {
      Inputs.down.toggle(e, pressed);
    }
    if(kc == KeyEvent.VK_D || kc == KeyEvent.VK_RIGHT) {
      Inputs.right.toggle(e, pressed);
    }
    if(kc == KeyEvent.VK_SPACE) {
      Inputs.confirm.toggle(e, pressed);
    }
    if(kc == KeyEvent.VK_ESCAPE) {
      Inputs.escape.toggle(e, pressed);
    }
    if(kc == KeyEvent.VK_F) {fps.toggle(e, pressed);}
//  if(kc == KeyEvent.VK_W || kc == KeyEvent.VK_UP) {up.toggle(e, pressed);}
  }
}
