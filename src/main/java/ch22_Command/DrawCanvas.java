package ch22_Command;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/11
 */
public class DrawCanvas extends Canvas implements Drawable {
  private final Color color = Color.RED;
  private final int radius = 6;
  private final MacroCommand history;

  public DrawCanvas(int width, int height, MacroCommand history) {
    setSize(width, height);
    setBackground(Color.WHITE);
    this.history = history;
  }

  public void paint(Graphics g) {
    history.execute();
  }

  @Override
  public void draw(int x, int y) {
    Graphics g = getGraphics();
    g.setColor(color);
    g.fillOval(x - radius, y - radius,
        radius * 2, radius * 2);
  }
}
