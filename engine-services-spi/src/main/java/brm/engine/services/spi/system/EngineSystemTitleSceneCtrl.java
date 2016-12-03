package brm.engine.services.spi.system;


/**
 * A title-screen control. A title screen may have a large number of elements, not all of them visual. The title screen
 * is made of one or more background images, possible sound effects and music, and a number of useful buttons to manage
 * starting or loading a game or accessing game information.
 * @author Gregory
 */
public interface EngineSystemTitleSceneCtrl {
  /**
   * Provide music. These are the background musics that may play while on the title screen (either in given succession
   * or in random order.)
   * <p>
   * add background music -- musical interludes for the title screen
   * @see EngineSystemTitleSceneCtrl
   */
  default public Object[] providedMediaBGM() {
    return null;
  }

  /**
   * Provide sound. These are the background sounds that may be randomly played while the title screen is active.
   * <p>
   * add sound effects -- example: birds twittering, random storm/lightning strikes, monster growls, character speech,
   * etc.
   * @see EngineSystemTitleSceneCtrl
   */
  default public Object[] providedMediaSFX() {
    return null;
  }

  /**
   * Provide controls. These are the buttons that appear on the title screen.
   * <p>
   * add one or more controls to the title screen; the class instance for each may define where and how they are
   * displayed
   * @see EngineSystemTitleSceneCtrl
   */
  default public Object[] providedControls() {
    return null;
  }
}
