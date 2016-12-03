package brm.engine.services.spi;
import java.util.List;


/**
 * The engine extension interface. Methods which are not used in the implementation class only return default value.
 * <p>
 * This interface is an SPI for engine data; specifically, the loading and instantiating of modules for the engine. Its
 * purpose is to specify information about the extension (name, note, text), and provide the necessary extension points
 * back to the engine itself. The latter could be some "system resource" (audio, images), or a "title scene control" (a
 * button or element for the Title Screen), or "unique" modules (new forms of game data which may require addition to a
 * regular update-cycle), or the enable-disable state (whether disable-able or disabled).
 * <h1>Implementing This Interface.</h1>
 * All of the class-based return types used in this SPI-type infrastructure are interfaces, so that the developer could
 * have a class which extends another class, for instance, my {@code Crypto} class, which allows encrypting/decrypting
 * of binary-saved data relevant to the module.
 * <p>
 * In general, the only method which MUST be implemented, is the {@code providedEngineUpdateData()} method, containing
 * baseline methodology for describing the extension and the update location. But it is advisable to provide as much of
 * the methodology as contained in these interfaces, to break up relevant portions of a service-loading into a separate
 * place. Further, the only required method from that is the method that gives the name of the extension. Any or all of
 * the included methods may be used in whatever combinations that will allow the extension to be registered and operate
 * as expected.
 * <p>
 * For example, most extensions might not have need to add "title screen controls", such as buttons or links; but, some
 * modules might by necessity be capable of being disabled, and this interface methodology should allow for this factor
 * to be handled.
 * <h1>Legal Issues.</h1>
 * First, third-party extension providers should agree to a small set of legal points, before continuing development:
 * <ul>
 * <li>An extension should not be an exact copy of existing modules, either core or third-party in nature. Each module
 * should be as unique as logically possible; an extension is used to provide additional functionality that is not held
 * or provided elsewhere.
 * <li>An extension should not delete any data or files from "other" extensions, either core or third-party in nature.
 * Every module should not interfere with the normal load-save functionality of any module other than its own data, so
 * that legal retaliation shall not be required. The data or files mentioned refers to anything saveable or loadable in
 * binary form, and extends to in-memory data in those running modules.
 * <li>An extension should not be used to duplicate game assets, either encrypted or not, in any "unencrypted" format,
 * to any location outside the game. This is to protect a content-creator's rights or responsibilities of copyright, as
 * well as the general flow of distribution of game content.
 * </ul>and that's it, for now. Generally, the rules inhabiting the game engine as well as the third-party modules will
 * be the same as possible: a game is intended to be entertaining, educational, and a worthwhile diversion from "normal
 * life" things. We want both the game players and developers to have as valuable a playing or developing experience as
 * possible. Nothing more is required at this time.
 * <h1>Final Notes.</h1>
 * A lot of this SPI-related infrastructure was formalized after reading and re-reading Oracle's "Java Learning Trails"
 * &mdash; especially the part about creating extensible applications. Oracle Corporation is the "de facto" resource on
 * all things Java-related.
 * <p>
 * It should be somewhat obvious from examination of this interface, I have attempted to make a loadable service that's
 * as modular as necessary, so that extension providers do not have to implement methods from interfaces which will not
 * apply; most methods which return a value, will by default return a null or default value, so that only an overriding
 * instance of some interface should need to be developed.
 * <p>
 * For the starting steps in developing an engine extension, a developer only has to create one or more project(s) that
 * have compile-time dependencies on the Engine modules, on the `abc.core` modules, as well as any additional libraries
 * which may be used, as will be necessary. The engine dependency should be obvious &mdash; ergo the purpose of "engine
 * extensions" &mdash; but the rest, even my `abc.core` libraries, could be avoided, though for the sake of continuity,
 * `abc.core` may be advisable in some places; other libraries may only be required if the extension-developer would so
 * decide to utilize additional functionality.
 * @author Gregory
 * @see #providedEngineUpdateData() providedEngineUpdateData()
 * @see #providedEngineSystemData() providedEngineSystemData()
 * @see #canDisable() canDisable()
 * @see #isDisabled() isDisabled()
 * @see #priority() priority()
 */
public interface EngineExtender extends Processing {
  /**
   * Provide engine update data. This holds both the general textual information about an extension itself (name, note,
   * text) as well as any "update center" module information (URL, provided version).
   * @return An {@link EngineUpdateData} object.
   * @see EngineExtender
   * @see EngineUpdateData
   */
  public EngineUpdateData providedEngineUpdateData();

  /**
   * Provide engine system data.
   * @return An {@link EngineSystemData} object.
   * @see EngineExtender
   * @see EngineSystemData
   */
  default public EngineSystemData providedEngineSystemData() {
    return null;
  }

  /**
   * Can disable. This is true by default, for third-party content modules; if you wish your module to not be disabled,
   * once installed, simply override this method and either return true, or the boolean result of some comparison.
   * <p>
   * In a future iteration, this method may contain a parameter provided from the engine loading methodology, such as a
   * {@link List} object containing all disabled references. This may be good to allow third-party modules to know the
   * prerequisite modules that may have been disabled already.
   * @return A {@link Boolean} condition.
   * @see EngineExtender
   */
  default public boolean canDisable() {
    return true;
  }

  /**
   * Is disabled. This returns the value of whether or not the engine extender is currently disabled.
   * <p>
   * This is false by default, due to new extension modules needing to be enabled at least once, automatically. This is
   * so that the extender can examine whether it will work for the given state of the end-user's game.
   * @return A {@link Boolean} condition.
   * @see EngineExtender
   */
  default public boolean isDisabled() {
    return false;
  }

  /**
   * The ordinal value. This is a provided "hint" to the module sorting methodology for ordering in a list. Byte values
   * are used because the range of sortable engine extensions are not expected to collide at all, if ever. Generally, a
   * value closer to the minimum byte value is earliest in the list, and a value closer to the maximum byte value shall
   * be latest in the list.
   * @return An {@link Integer} value.
   * @see EngineExtender
   */
  default public byte priority() {
    return Byte.MAX_VALUE;
  }
}
///**
// * Provide game-play controls.
// * @see EngineExtender
// */
//default public Object[] providedGameplayControls() {
//  return null;
//}
