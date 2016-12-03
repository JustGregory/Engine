package brm.engine.services.spi;


/**
 * Engine update data. This allows providing the raw description data for the extension module, as well as any updating
 * data that can be used to download or install a newer version of this module.
 * <h1>About Updating.</h1>
 * An update check is only provided once, per game session, at the usual initialization time; if an update can be found
 * and installed, this will happen before entering the game.
 * <h1>Miscellaneous Data.</h1>
 * This interface also provides methods to obtain the module's name, a brief note, and a more complex text description,
 * as and where necessary. These strings can be internationalized as necessary, although as a minimum requirement, this
 * instance must give the module name itself; and, while the name could be internationalized, it should be equally easy
 * to find regardless of the language the module texts are translated into.
 * @author Gregory
 */
public interface EngineUpdateData {
  /**
   * The extender name. This is used as a descriptive title of the engine data module. It is the only method "required"
   * by this interface, as we should at least have a name for the extension.
   * @return A {@link String} object.
   * @see EngineUpdateData
   */
  public String name();

  /**
   * The extender note. This is a brief descriptive note, usually a short sentence that declares the purpose.
   * @return A {@link String} object.
   * @see EngineUpdateData
   */
  default public String note() {
    return "";
  }

  /**
   * The extender text. This is useful for a more complex description, as may be shown in the editor and error-handling
   * methodologies.
   * @return A {@link String} object.
   * @see EngineUpdateData
   */
  default public String text() {
    return "";
  }

  /**
   * The extender URL. This is the resource location for finding an update of the required module.
   * @return A {@link String} object.
   * @see EngineUpdateData
   */
  default public String url() {
    return "";
  }

  /**
   * The extender version. This is the version of the extension module itself, used to compare against the version that
   * is found from the {@link #url() url()} method, above.
   * @return A {@link String} object.
   * @see EngineUpdateData
   */
  default public String version() {
    return "";
  }
}
