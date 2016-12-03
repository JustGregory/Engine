package brm.engine.interpreter.commands;
import brm.engine.interpreter.enums.Fade;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
//import static rgss.modules.DataManager.game_message;


/**
 * A screen fade command. This handles fading actions such as fade-out, fade-in, fade-out-then-in, or fade-in-then-out.
 * <p>
 * Normally, the resulting action is either a fade out on one scene, or a fade in on another scene. The other remaining
 * possibilities are for complex multi-fading potentials.
 * <p>
 * The default for RPG Maker VX Ace uses "30" as the fade time &mdash; would that be thirty <i>seconds</i>? or, will it
 * be thirty <i>frames</i>?
 * @author Gregory
 */
public class CommandScreenFade extends CommandScreen {
  /**
   * Begin fade level. Normally, fade out operations start at full, and fade in operations start at zero; more complex
   * operations depend upon the basic state of the screen brightness at the time this operation is begun.
   */
  private byte begin;
  /**
   * End fade level.
   */
  private byte end;
  /**
   * The fade time.
   */
  private byte time;
  /**
   * The fade type.
   */
  private Fade type;

  @Override
  public void doAction() {
    // first, outer switch/case for determining type of fade
    switch(type) {
      case fade0: // fade out
        doFade0();
        break;
      case fade1: // fade in
        doFade1();
        break;
      case fade2: // fade out, then in
        doFade2();
        break;
      case fade3: // fade in, then out
        doFade3();
        break;
      case fade4: // fade other...
        doFade4();
        break;
    }
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      type = Fade.fromId(dis.readByte());
      // reading this fade instance's values based upon the type
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeByte(type.ordinal());
      // writing this fade instance's values based upon the type
    }
  }

  private void doFade0() { // fade out -- command 221
    if(game_message.visible) {
      Thread.yield();
    }
    screen().start_fadeout(30);
    wait(30);
  }

  private void doFade1() { // fade in -- command 222
    if(game_message.visible) {
      Thread.yield();
    }
    screen().start_fadein(30);
    wait(30);
  }

  private void doFade2() { // fade out, then in
  }

  private void doFade3() { // fade in, then out
  }

  private void doFade4() { // fade other...
  }
}
/*
 */
