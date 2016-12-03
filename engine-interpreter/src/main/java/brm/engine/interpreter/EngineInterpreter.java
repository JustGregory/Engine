package brm.engine.interpreter;


/**
 * The engine interpreter. This singleton class holds references for the various interpreter commands, as well as lists
 * for keeping events handy.
 * @author Gregory
 * @see #instance instance
 * @see #EngineInterpreter() EngineInterpreter()
 */
public class EngineInterpreter {
  /**
   * The default {@link EngineInterpreter} instance.
   * @see EngineInterpreter
   */
  public static final EngineInterpreter instance;

  static {
    instance = new EngineInterpreter();
  }

  private EngineInterpreter() {
  }
}
