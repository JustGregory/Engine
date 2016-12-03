package brm.engine.game.inputs.enums;


/**
 *
 * @author Gregory
 */
public enum InputLock {
  //  moves  other  title
  il0(false, false, "Unlocked", ""),
  il1(false, false, "Locked:Event", ""),
  il2(false, false, "Locked:State", ""),
  il3(false, false, "Locked:System", "");
  public final String title;
  public final String descr;
  public final boolean allowMovement; // movement: up, down, left, right, dash/speed,
  public final boolean allowNavigate; // navigate: cancel/menu, confirm/ok/enter, prev-page, next-page, quick-menu?

  private InputLock(boolean b, boolean c, String s, String t) {
    allowMovement = b;
    allowNavigate = c;
    title = s;
    descr = t;
  }
}
