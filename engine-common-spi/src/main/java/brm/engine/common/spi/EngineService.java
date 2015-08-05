package brm.engine.common.spi;
import brm.engine.common.spi.gamefile.GameFile;
import brm.engine.common.spi.systems.ProvideSystemBattling;
import brm.engine.common.spi.systems.ProvideSystemCrafting;


/**
 * The core engine service. This is the primary interface to extend a class, when providing custom modules.
 * @author Gregory
 */
public interface EngineService {
  /**
   * Provide a GameFile instance for the SPI handler. This may return null, if no actual data is loaded or saved by the
   * module.
   * @return A {@link GameFile} object.
   * @see EngineService
   */
  abstract public GameFile provideGameFile();

  /**
   * Provide a Battling System. This will provide a complete battling system to the engine, so multiple battle systems
   * may coexist.
   * @return A {@link ProvideSystemBattling} object.
   * @see EngineService
   */
  abstract public ProvideSystemBattling provideSystemBattling();

  /**
   * Provide a Crafting System. This will provide a complete crafting system to the engine, so different crafting modes
   * may coexist.
   * @return A {@link ProvideSystemCrafting} object.
   * @see EngineService
   */
  abstract public ProvideSystemCrafting provideSystemCrafting();
}
