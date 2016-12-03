package brm.engine.common.spi.gamefile;
import brm.engine.common.spi.gamefile.enums.GameDataType;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * The "game loadable" annotation. This allows defining metadata for a module's handling of the game-load function.
 * <p>
 * It is presumed the absence of this annotation on a module project's main class means that no loadable methodology is
 * maintained for the class and its data; the presence of such means that a custom annotation processor at runtime will
 * allow loading of game data.
 * <p>
 * Also, where a module defines this annotation, it most likely will also define a {@link GameSaveable} annotation.
 * @author Gregory
 * @version 2015/July 25
 * @see #extension() extension()
 * @see #filename() filename()
 * @see #gameDataType() gameDataType()
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Gamedata {
  /**
   * The game-data file extension. This is the file-extension used for loading and saving of data; it is used when this
   * module's data-type is {@link GameDataType#ingameData} (default), the filename base will be provided as referenced
   * to the save-file name (which contains an ordinal integer for the slot-ID) and the {@link #filename() filename()}
   * value should be empty by default. Otherwise, both the extension and the root filename should be specified.
   * @return A {@link String} object.
   * @see Gamedata
   */
  public String extension();

  /**
   * The game-data type. This defines the purpose of the game data, and may provide a hint to how its information might
   * be saved.
   * @return A {@link String} object.
   * @see Gamedata
   */
  public String filename();

  /**
   * The game-data type. This defines the purpose of the game data, and may provide a hint to how its information might
   * be saved.
   * @return A {@link GameDataType} instance.
   * @see Gamedata
   */
  public GameDataType gameDataType() default GameDataType.ingameData;
}
