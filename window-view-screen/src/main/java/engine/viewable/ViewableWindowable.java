/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.viewable;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Window;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 * <h2>ViewableWindowable</h2>
 * something
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
    return null;
  }
}
