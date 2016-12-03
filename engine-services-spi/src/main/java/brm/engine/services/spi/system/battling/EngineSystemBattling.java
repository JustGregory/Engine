package brm.engine.services.spi.system.battling;


/**
 * A "Battling System".
 * @author Gregory
 */
public interface EngineSystemBattling {
  // methods for the execution-handler: methodologies for entering or exiting battle-state, and during the battle turn;
  // this is just the interface, and so does not return anything but null or default values.

  /**
   * Before a battle. The object returned from this method is used to handle what happens before the battle processing,
   * such as setting up the layout, displaying any hints or tips, and placement of things.
   * @see EngineSystemBattling
   */
  default public Object handlerBattlingBefore() {
    return null;
  }

  /**
   * During a battle. The object returned from this method is used to handle the actual iterative battle turns, as well
   * as both enemy and friendly automated actions per turn. In some sense, this may also control the "enemy AI" &mdash;
   * @see EngineSystemBattling
   */
  default public Object handlerBattlingDuring() {
    return null;
  }

  /**
   * Finish a battle.
   * @see EngineSystemBattling
   */
  default public Object handlerBattlingFinish() {
    return null;
  }
}
