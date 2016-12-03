package brm.engine.common.spi.systems;


/**
 * A provider of engine systems.
 * <h1>What Is A System</h1>
 * An engine "system" is a set of one or more component parts that work together to provide functionality for the whole
 * game. In this sense, things such as the battling and crafting elements in role-playing games are such.
 * <p>
 * Nearly all systems have one or more aspects that are important:
 * <ul>
 * <li>what is performed in the background, as essential functionality;
 * <li>what is displayed on-screen, including general menu layout;
 * <li>any other useful aspects, such as user-input and management.
 * </ul>
 * @author Gregory
 */
abstract public class AProvideSystem {
  protected String name;

  public AProvideSystem() {
  }
}
