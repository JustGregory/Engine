package brm.engine.config;
import abc.cryptology.AbcCryptology;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.NoSuchPaddingException;


/**
 * Engine configuration. This class handles configuration data that controls how the engine will operate. This includes
 * audio and video control, and user-preferences for other aspects of an engine or game module.
 * @author Gregory
 */
public class EngineConfig {
  public static final EngineConfig instance;

  static {
    instance = new EngineConfig();
  }

  private final LogicEngineConfig config = new LogicEngineConfig();

  private EngineConfig() {
  }

  /**
   * Load a configuration.
   * @param l A {@link Long} value, representing a seed value for decrypting.
   * @param f A {@link File} object, representing an abstract file path name.
   * @param s A {@link String} object, representing the cryptography type.
   * @param t A {@link String} object, representing the cryptographic key.
   * @throws java.security.NoSuchAlgorithmException
   * @throws java.security.spec.InvalidKeySpecException
   * @throws javax.crypto.NoSuchPaddingException
   * @throws java.security.InvalidKeyException
   * @throws java.security.InvalidAlgorithmParameterException
   * @throws java.io.FileNotFoundException
   */
  public void configLoad(long l, File f, String s, String t) throws NoSuchAlgorithmException, InvalidKeySpecException,
      NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, FileNotFoundException, IOException {
    AbcCryptology.instance.performDecryption(l, config, s, f, t);
  }

  /**
   * Save a configuration.
   * @param l A {@link Long} value, representing a seed value for decrypting.
   * @param f A {@link File} object, representing an abstract file path name.
   * @param s A {@link String} object, representing the cryptography type.
   * @param t A {@link String} object, representing the cryptographic key.
   * @throws java.security.NoSuchAlgorithmException
   * @throws java.security.spec.InvalidKeySpecException
   * @throws javax.crypto.NoSuchPaddingException
   * @throws java.security.InvalidKeyException
   * @throws java.security.InvalidAlgorithmParameterException
   * @throws java.io.FileNotFoundException
   */
  public void configSave(long l, File f, String s, String t) throws NoSuchAlgorithmException, InvalidKeySpecException,
      NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, FileNotFoundException, IOException {
    AbcCryptology.instance.performEncryption(l, config, s, f, t);
  }
}
