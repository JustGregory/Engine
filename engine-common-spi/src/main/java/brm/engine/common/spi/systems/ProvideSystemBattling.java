package brm.engine.common.spi.systems;


/**
 * Provide a battling system.
 * <h1>Battle System Components</h1>
 * For example, with a battle system, we have a few key points of concern.
 * <ul>
 * <li/>The battle system is rendered each game-tick, displaying the current state of operation, including rendering of
 * game layout to the manner the game-maker has decided.
 * <li/>The battle system, for each character's turn, will allow for user-input to be taken and recorded so that a game
 * turn may be performed.
 * <li/>After character actions are selected, the battle actions are performed in the turn.
 * </ul>
 * And finally,
 * @author Gregory
 */
abstract public class ProvideSystemBattling extends AProvideSystem {

  abstract public Object getLayout();

  abstract public Object getTicker();
}
