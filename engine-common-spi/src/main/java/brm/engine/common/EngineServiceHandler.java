package brm.engine.common;
import brm.engine.common.spi.EngineService;
import brm.engine.common.spi.gamefile.GameFile;
import brm.engine.common.spi.gamefile.GameFileManagement;
import java.util.Iterator;
import java.util.ServiceLoader;


/**
 * The engine services singleton. This is the main entry point for managing all SPI-related classes.
 * <h1>How It Works</h1>
 * At engine initialization, this singleton class causes the {@link ServiceLoader} class to seek out and load modules
 * that contain valid implementations of other SPI interfaces; the methods in this class duplicate those defined in the
 * {@link EngineService} interface; the methods here merely iterate through the instances in {@link ServiceLoader} for
 * performing the specified methodology.
 * @author Gregory
 * @see #instance instance
 * @see #loader loader
 * @see #EngineServices()EngineServiceHandler()
 */
public class EngineServiceHandler {
  /**
   * The default {@link EngineServiceHandler} instance.
   * @see #EngineServices
   */
  public static final EngineServiceHandler instance;

  static {
    instance = new EngineServiceHandler();
  }

  private final ServiceLoader<EngineService> loader;

  private EngineServiceHandler() {
    loader = ServiceLoader.load(EngineService.class);
  }

  public final void initializeServices() {
    Iterator<EngineService> iterator = loader.iterator();
    while(iterator.hasNext()) {
      EngineService service = iterator.next();
      // provide game file SPI
      GameFile gameFile = service.provideGameFile();
      if(gameFile != null) {
        GameFileManagement.instance.provideGameFileService(gameFile);
      }
    }
  }
}
//Finally, do not forget to add into the module resources, the following:
//  META-INF/services/brm.engine.common.spi.EngineService
//which is a text file with the full pathname to the implementation of EngineService
