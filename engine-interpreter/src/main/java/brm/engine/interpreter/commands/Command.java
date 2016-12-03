package brm.engine.interpreter.commands;
import abc.cryptology.logics.Crypto;
import rgss.gameobjects.Game_Screen;
import static rgss.modules.DataManager.game_map;
import static rgss.modules.DataManager.game_party;
import static rgss.modules.DataManager.game_troop;


/**
 * An abstract command. This is the parent class for all of the in-game command instances, to be used in event code.<p>
 * This class has a few subclasses, which themselves have specific subclasses which are the command classes that are to
 * be performed.
 * @author Gregory
 */
abstract public class Command extends Crypto {
  /**
   * Do the command action. This is the method where the particular command events should be performed.
   * @see Command
   */
  abstract public void doAction();

  protected final Game_Screen screen() {
    return game_party.in_battle
        ? game_troop.screen
        : game_map.getScreen();
  }

  /**
   * Wait some seconds. This is like the {@link #wait(long) wait(long)} method in the {@link Object} class, but we do
   * <i>not</i> want the entire program to freeze for this time, but we want the game to continue processing this basic
   * command instance. (I am thinking we need to rethink how "waiting" is done...)
   * @param i An {@link Integer} value, representing the duration to wait.
   * @see Command
   */
  protected final void wait(int i) {
    // pass on the wait command to elsewhere, to cause actions to freeze player and on-map entities from acting.
  }
}
