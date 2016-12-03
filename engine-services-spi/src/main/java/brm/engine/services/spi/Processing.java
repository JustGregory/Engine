package brm.engine.services.spi;


/**
 * Base processing. This interface adds methods for implementing initialization, loading, saving, and quitting from the
 * engine implementation.
 * @author Gregory
 * @see #servicesInit() servicesInit()
 * @see #servicesLoad() servicesLoad()
 * @see #servicesQuit() servicesQuit()
 * @see #servicesSave() servicesSave()
 */
public interface Processing {
  /**
   * Init action. An extender will be initialized, setting up everything necessary to proper processing.
   * @see Processing
   */
  default public void servicesInit() {
  }

  /**
   * Load action. An extender will be loaded if and where its data may need to be processed.
   * @see Processing
   */
  default public void servicesLoad() {
  }

  /**
   * Quit action. An extender will handle being shut down, in preparation of the engine quitting.
   * @see Processing
   */
  default public void servicesQuit() {
  }

  /**
   * Save action. An extender will be saved, where in-memory data may be required for retention.
   * @see Processing
   */
  default public void servicesSave() {
  }
}
