package ch22_Command;

import ch22_Command.command.MacroCommand;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/11
 */
public class DrawCanvas extends Canvas implements Drawable {
  private Color color = Color.RED;
  private final int radius = 6;
  private final MacroCommand history;

  public DrawCanvas(int width, int height, MacroCommand history) {
    setSize(width, height);
    setBackground(Color.WHITE);
    this.history = history;
  }

  public void paint(Graphics g) {
    // 比较坑的一个点，需要在每次撤销时将画布置为初始画色
    setColor(Color.RED);
    history.execute();
  }

  @Override
  public void draw(int x, int y) {
    Graphics g = getGraphics();
    g.setColor(color);
    g.fillOval(x - radius, y - radius,
        radius * 2, radius * 2);
  }

  @Override
  public void cancel() {
    history.undo();
    repaint();
  }

  public void setColor(Color color) {
    this.color = color;
  }
}
