package brm.engine.interpreter.commands;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Command201. "Transfer Player" command.
 * @author Gregory
 */
public final class Command201 extends Command {
  /**
   * The command parameters.
   * <ul>
   * <li>Index 0 is how the move is designated: directly, or via variables. If zero, transfer by a direct designation;
   * anything else means by using variables to find the map, x, and y.
   * <li>Index 1 through 3 is the transfer location: map id, map x, and map y.
   * <li>Index 4 is the directional facing upon being transferred.
   * <li>Index 5 is the fade type when leaving from or coming into a map.
   * </ul>
   * In the above, we use a Short[] array; though index 0 could be a Boolean, index 4 could be a Byte, index 5 could be
   * an enumeration instance. Indexes 1-3 are generally fine in being Short, although for 1, it's not necessary to be a
   * short if there are not more than 255 maps &mdash; except for the fact that larger games may, in fact, have quite a
   * lot more than 255 variables. (If we pull values from global variables, would they be shorts, or integers?)
   * <p>
   * The only other way to achieve this than reading values in from the performDecryption method, is by including these
   * values in a constructor, and manually setting the values at construction time.
   */
  private short[] params; // = { designate, mapId, mapX, mapY, dirFacing, fadeType };

  @Override
  public synchronized void doAction() {
    boolean b = false;
    // the above should equate to:  $game_party.in_battle
    // the below should contain the above conditional statement.
    if(!b) {
//    Fiber.yield while $game_player.transfer? || $game_message.visible
//    if @params[0] == 0                      # Direct designation
//      map_id = @params[1]
//      x = @params[2]
//      y = @params[3]
//    else                                    # Designation with variables
//      map_id = $game_variables[@params[1]]
//      x = $game_variables[@params[2]]
//      y = $game_variables[@params[3]]
//    end
//    $game_player.reserve_transfer(map_id, x, y, @params[4])
//    $game_temp.fade_type = @params[5]
//    Fiber.yield while $game_player.transfer?
    }
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
    }
  }
}
