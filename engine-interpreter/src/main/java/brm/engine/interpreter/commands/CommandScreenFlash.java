package brm.engine.interpreter.commands;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import rgss.Color;


/**
 * A screen flash operation. This defines the aspects of an event command for flashing the screen.
 * @author Gregory
 */
public class CommandScreenFlash extends CommandScreen {
  // parameters from the doAction() method....
  /**
   * @see CommandScreenFlash
   */
  private Color color;  // params[0] = flash color/tone;
  /**
   * @see CommandScreenFlash
   */
  private int duration; // params[1] = duration;
  /**
   * @see CommandScreenFlash
   */
  private boolean wait; // params[2] = some boolean wait condition?

  @Override
  public void doAction() {
//  screen.start_flash(@params[0], @params[1])
//  wait(@params[1]) if @params[2]
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    color = new Color(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt());
    duration = dis.readInt();
    wait = dis.readBoolean();
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
  }
}
