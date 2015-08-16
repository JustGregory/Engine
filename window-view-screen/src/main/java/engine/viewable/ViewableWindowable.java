package engine.viewable;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;


/**
 * The windowed viewable component.
 * @author Gregory
 */
public class ViewableWindowable extends Viewable {
  private final JFrame frame;

  public ViewableWindowable(int i, int j, String s) {
    super(i, j, s);
    frame = new JFrame(title);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setPreferredSize(new Dimension(sizeWidth, sizeHeight));
    frame.pack();
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setVisible(true);
  }

  @Override
  protected BufferStrategy getBufferStrategy() {
    return frame.getBufferStrategy();
  }

  @Override
  protected Graphics2D getGraphics2D() {
    return (Graphics2D)frame.getGraphics();
  }

  @Override
  protected Window getWindow() {
    return frame;
  }
}
