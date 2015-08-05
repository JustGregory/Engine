package brm.engine.common.spi.gamefile;
import java.util.ArrayList;


/**
 * The {@link GameFile}-related SPI infrastructure. This is the provider for all instances of file loading, saving, and
 * quitting the data files.
 * @author Gregory
 * @see #instance instance
 * @see #GameFileServices()GameFileManagement()
 */
public class GameFileManagement {
  /**
   * The default {@link GameFileManagement} instance.
   * @see #GameFileServices
   */
  public static final GameFileManagement instance;

  static {
    instance = new GameFileManagement();
  }

  private final ArrayList<GameFile> list;

  {
    list = new ArrayList<>(0);
  }

  private GameFileManagement() {
  }

  public final boolean isLoadable() {
    for(GameFile gf : list) {
      if(!gf.isLoadable()) {
        // should we give a message about the gamefile not being loadable?
        return false;
      }
    }
    return true;
  }

  public final boolean isLoaded() {
    for(GameFile gf : list) {
      if(!gf.isLoaded()) {
        // should we give a message about the gamefile not being loaded?
        return false;
      }
    }
    return true;
  }

  public final boolean isSaveable() {
    for(GameFile gf : list) {
      if(!gf.isSaveable()) {
        // should we give a message about the gamefile not being saveable?
        return false;
      }
    }
    return true;
  }

  public final boolean isSaved() {
    for(GameFile gf : list) {
      if(!gf.isSaved()) {
        // should we give a message about the gamefile not being saved?
        return false;
      }
    }
    return true;
  }

  public final void onGameFileLoadBefore() {
    for(GameFile gf : list) {
      gf.onGameFileLoadBefore();
    }
  }

  public final void onGameFileLoadDuring() {
    for(GameFile gf : list) {
      gf.onGameFileLoadDuring();
    }
  }

  public final void onGameFileLoadFinish() {
    for(GameFile gf : list) {
      gf.onGameFileLoadFinish();
    }
  }

  public final void onGameFileQuitBefore() {
    for(GameFile gf : list) {
      gf.onGameFileQuitBefore();
    }
  }

  public final void onGameFileQuitDuring() {
    for(GameFile gf : list) {
      gf.onGameFileQuitDuring();
    }
  }

  public final void onGameFileQuitFinish() {
    for(GameFile gf : list) {
      gf.onGameFileQuitFinish();
    }
  }

  public final void onGameFileSaveBefore() {
    for(GameFile gf : list) {
      gf.onGameFileSaveBefore();
    }
  }

  public final void onGameFileSaveDuring() {
    for(GameFile gf : list) {
      gf.onGameFileSaveDuring();
    }
  }

  public final void onGameFileSaveFinish() {
    for(GameFile gf : list) {
      gf.onGameFileSaveFinish();
    }
  }

  public final void provideGameFileService(GameFile gf) {
    if(gf != null && !list.contains(gf)) {
      list.add(gf);
    }
  }
}
