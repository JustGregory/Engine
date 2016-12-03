package brm.engine.common.spi.gamefile.enums;


/**
 * The game-data type. This enumeration defines how game-save information is processed; at least three methods exist at
 * this time: engine-only data, game-metadata, and in-game data.
 * @author Gregory
 * @version 2015/July 30
 */
public enum GameDataType {
  /**
   * The data is for the engine only. This is for the loading and saving of engine-specific data which a developer will
   * include for handling of the custom engine data.
   * @see GameDataType
   */
  engineOnly,
  /**
   * The data is for meta-game information. This is for loading and saving of things which may carry over to other game
   * session that a user may play; such as created characters, meta-game recording information, and anything that might
   * be usable from any game session.
   * @see GameDataType
   */
  gameMeta,
  /**
   * The data is for in-game data. This is for loading and saving those parts of an actual game-play session to or from
   * a file.
   * @see GameDataType
   */
  ingameData;

  private GameDataType() {
  }
}
