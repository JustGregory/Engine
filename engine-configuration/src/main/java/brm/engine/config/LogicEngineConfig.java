package brm.engine.config;
import abc.cryptology.logics.ACryptoLogic;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The engine configuration-data logic.
 * @author Gregory
 */
class LogicEngineConfig extends ACryptoLogic {
  // fields should be private, and the getter/setter methods protected, so that EngineConfig can access them.
  private boolean changed = false; // setter methods set this to true; only an encryption (save) sets this to false....

  LogicEngineConfig() {
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
  }

  public boolean isChanged() {
    return changed;
  }

  //TODO: ACryptoLogic should contain a boolean method to determine if changed, if saved, etc...?
}
