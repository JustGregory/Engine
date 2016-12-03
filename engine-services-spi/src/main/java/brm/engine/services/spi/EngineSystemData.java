package brm.engine.services.spi;
import brm.engine.services.spi.system.EngineSystemResource;
import brm.engine.services.spi.system.EngineSystemTitleSceneCtrl;
import brm.engine.services.spi.system.EngineSystemUniqueModule;


/**
 * The engine system data. This provides additional system resources, title scene controls, and unique modules.
 * @author Gregory
 * @see #providedSystemResource() providedSystemResource()
 * @see #providedSystemTitleSceneCtrl() providedSystemTitleSceneCtrl()
 * @see #providedSystemUniqueModules() providedSystemUniqueModules()
 */
public interface EngineSystemData extends Processing {
  /**
   * Provide system resources. This is null for most extensions, but the engine internals may use this to provide the
   * core resources.
   * @return An {@link EngineSystemResource} object.
   * @see EngineSystemData
   * @see EngineSystemResource
   */
  default public EngineSystemResource providedSystemResource() {
    return null;
  }

  /**
   * Provide title-scene controls. This allows for adding in additional controls and baseline features to the primary
   * title screen.
   * @return An {@link EngineSystemTitleSceneCtrl} object.
   * @see EngineSystemData
   * @see EngineSystemTitleSceneCtrl
   */
  default public EngineSystemTitleSceneCtrl[] providedSystemTitleSceneCtrl() {
    return null;
  }

  /**
   * Provide system modules. This is for providing references to custom "core-level" modules that add new features, NOT
   * merely sub-classing and extending existing functionality.
   * @return An {@link EngineSystemUniqueModule} array.
   * @see EngineSystemData
   * @see EngineSystemUniqueModule
   */
  default public EngineSystemUniqueModule[] providedSystemUniqueModules() {
    return null;
  }
}
