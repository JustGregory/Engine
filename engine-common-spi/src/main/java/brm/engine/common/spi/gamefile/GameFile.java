package brm.engine.common.spi.gamefile;
import java.io.File;


/**
 * A game file definition interface. This defines the file-management and file-operation methodology, to be used in the
 * {@link GameFileService} SPI.
 * <h1>Game File Operations</h1>
 * In an "rpg maker" (generalized), the main file operations that we will allow are as follows:
 * <ol>
 * <li><b>Loading a game.</b> A game that was previously played and saved can be loaded again. The game is loaded when
 * all of the data is read into memory, and it is ready to be run as a game.
 * <li><b>Saving a game.</b> A game is saved once all of the data that is required to load it back into the same exact
 * state as it is in now, is written to a save file. This allows a user to come back to it at a later time, without any
 * lost progress.
 * <li><b>Quitting a loaded game.</b> A game that is quit will be unloaded from memory but not saved; this is the same
 * as abandoning an active game session with no intention of going back to it. But, we might still need to perform some
 * activities on the module's data structures in order to make it ready for a new game, if so desired.
 * </ol>
 * and perhaps other functionality, though the main functionality will be the above, and extra supporting methodology.
 * <h1>Miscellaneous Notes</h1>
 * Within the realm of all game files, an actual "game save file" may be a collection of multiple files, each one being
 * individually parse-able. Within the context of this SPI, this allows us to develop individual modules which can save
 * data to a path, and load data again to the same state. But this also means that we must ensure our save-parts have a
 * unique name for each save.
 * <p>
 * Further, it is technically possible that a module could exist that <i>does not</i> load or save data; any module who
 * will not load or save, also does not need to provide an implementation of this.
 * <p>
 * A note about saving data: in the operation of game data, not every single field or object may need to be saved to be
 * a valid save-file. In the normal operation of a game, a module may use any number of temporary variables to exist at
 * runtime. One example of this is a character or hero: he will have the core statistics that are
 * @author Gregory
 */
public interface GameFile extends Iterable<GameFile> {
  /**
   * The root file object.
   * @see GameFile
   */
  File rootFile = null;
  /**
   * The save-file filename.
   * @see GameFile
   */
  String filename = "";
  /**
   * Is a file loaded. A game file is loaded
   * @see GameFile
   */
  boolean loaded = false;
  /**
   * Is a file loadable. A game file is loadable at most times; however, this is to denote whether other game file data
   * is loaded that would be lost when a loader operation is performed.
   * @see GameFile
   */
  boolean loadable = false;
  /**
   * Is a file saved. A game file is saved if the data has been saved to a file, so it can be loaded at another time.
   * @see GameFile
   */
  boolean saved = false;
  /**
   * Is a file saveable. A game file is saveable if the file is not null, if it is loaded, and if it is neither changed
   * nor has been saved yet.
   * @see GameFile
   */
  boolean saveable = false;

  /**
   * Whether we can load game data. This method will determine if data is to be loaded.
   * @return A {@link Boolean} condition.
   * @see GameFile
   */
  abstract public boolean isLoadable();

  /**
   * Whether game data is loaded. This method will determine if data is loaded and active.
   * @return A {@link Boolean} condition.
   * @see GameFile
   */
  abstract public boolean isLoaded();

  /**
   * Whether we can save game data. This method will determine if data is to be saved
   * @return A {@link Boolean} condition.
   * @see GameFile
   */
  abstract public boolean isSaveable();
  /**
   * Whether game data is saved. This method will determine if data is saved, and safe to be unloaded from memory (upon
   * either leaving this game for another, or for exiting the application).
   * @return A {@link Boolean} condition.
   * @see GameFile
   */
  abstract public boolean isSaved();

  /**
   * Before the game file load. This method will prepare an active game file loading.
   * @see GameFile
   */
  abstract public void onGameFileLoadBefore();

  /**
   * During the game file load. This method will perform an active game file loading.
   * @see GameFile
   */
  abstract public void onGameFileLoadDuring();

  /**
   * Finish the game file load. This method will cleanup an active game file loading.
   * @see GameFile
   */
  abstract public void onGameFileLoadFinish();

  /**
   * Before the game file quit. This method will prepare an active game save file closure.
   * @see GameFile
   */
  abstract public void onGameFileQuitBefore();

  /**
   * During the game file quit. This method will perform an active game save file closure.
   * @see GameFile
   */
  abstract public void onGameFileQuitDuring();

  /**
   * Finish the game file quit. This method will cleanup an active game save file closure.
   * @see GameFile
   */
  abstract public void onGameFileQuitFinish();

  /**
   * Before the game file save. This method will prepare an active game save process.
   * @see GameFile
   */
  abstract public void onGameFileSaveBefore();

  /**
   * During the game file save. This method will perform an active game save process.
   * @see GameFile
   */
  abstract public void onGameFileSaveDuring();

  /**
   * Finish the game file save. This method will cleanup an active game save process. A cleanup, in this context, is an
   * extended operation which may be performed after the main part of the game-file(s) are saved.
   * @see GameFile
   */
  abstract public void onGameFileSaveFinish();

  /**
   * Set the root file path. This sets the field via direct assignment. The method override may look like:
   * <blockquote><pre>
   * filename = String.format("%s_%s.%s", s, "theModuleName", "theExtension");
   * rootFile = new File(f, filename);</pre></blockquote>
   * This may be copied and personalized in the module's method. For example, the first part of the string format would
   * be the root part of the save file name; the second part would be any additional text specified as the data to load
   * in an implementation class. The "theExtension" is the default extension for the save-files; implementations should
   * define their own text label as the file-extension. (BeyondRM will use ".save" for its save files; please choose an
   * original word or abbreviation for saving custom module data...)
   * <p>
   * Further, while the values of the parameters are merely a "suggestion" and based upon practical design, a developer
   * could use another naming methodology; however, the above template code is reasonable to copy and modify, without a
   * real reason to go too far astray from it. The main point is, using the value in the string parameter as the prefix
   * to the rest of the save-file name, keeps things simple and understandable, when looking through the directory in a
   * file-explorer.
   * @param f A {@link File} object, representing the file-path where we will work.
   * @param s A {@link String} object, representing the base filename to use.
   * @see GameFile
   */
  abstract public void setRootFile(File f, String s);
}
