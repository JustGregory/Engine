package brm.engine.interpreter.enums;


/**
 * Screen fade modes. A screen fade is an action where the screen starts at one brightness, then fades to another, then
 * possibly back to another brightness.
 * @author Gregory
 */
public enum Fade {
  /**
   * Fade out.
   * <p>
   * This goes from full or the current brightness, down to no brightness (until the screen is black).
   * @see Fade
   */
  fade0((byte)0, "Fade Out"),
  /**
   * Fade in.
   * <p>
   * This goes from zero brightness, increasing to full brightness.
   * @see Fade
   */
  fade1((byte)1, "Fade In"),
  /**
   * Fade out, then in.
   * <p>
   * This is like a "fade out" followed by a "fade in", only in one concise action.
   * @see Fade
   */
  fade2((byte)2, "Fade Out, Then In"),
  /**
   * Fade in then out.
   * <p>
   * This is like a "fade in" followed by a "fade out", only in one concise action.
   * @see Fade
   */
  fade3((byte)3, "Fade In, Then Out"),
  /**
   * Fade other. This includes miscellaneous fading operations such as: a "repeated fade", a "multiple fade" operation,
   * and others.
   * <p>
   * This is for a complex multiple-fade continuing series.
   * @see Fade
   */
  fade4((byte)4, "Fade Repeated");
  /**
   * The fade name.
   * @see Fade
   */
  public final String name;
  public final byte code;

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @param b A {@link Byte} value, representing the {@link #code code}.
   * @param s A {@link String} object, representing the {@link #name name}.
   * @see Fade
   */
  private Fade(byte b, String s) {
    code = b;
    name = s;
  }

  /**
   * Get a fade type.
   * @param b A {@link Byte} value, representing a fade id.
   * @return A {@link Fade} instance.
   * @see Fade
   */
  public static final Fade fromId(byte b) {
    for(Fade value : values()) {
      if(value.code == b) {
        return value;
      }
    }
    return null;
  }
}
