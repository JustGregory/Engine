package brm.engine.services.spi.system;


/**
 * The engine system resource provider.
 * <p>
 * By overriding this interface and providing it as a returned object in an EngineData implementation, a developer may
 * add graphics resources to the engine or system. These may include one or more of the following:
 * <ol>
 * <li>balloons (thought-bubble icons, to make characters more "expressive")
 * <li>iconsets (images representing items and objects in the game menus)
 * <li>skinsets (visual "window UI": screen decor, for beautifying the layout)
 * <li>tilesets (tile-sheets used in mapping the game world and its locations)
 * <li>
 * </ol>
 * and other resources. Additional system resources could be for any new systems that haven't been incorporated within
 * the existing engine structure. One example might be for a "name list", for randomly-selecting an existing name from
 * a list of names, perfect for player-created characters such as recruitable NPCs.
 * @author Gregory
 */
public interface EngineSystemResource {
  // interface methods which define a "system resource".... Typically, for getting the "type" of resource, whether the
  // resource is saveable, and the link to the resource itself.

  default public String[] resourceImages() {
    return null;
  }

  default public String[] resourceSounds() {
    return null;
  }
}
