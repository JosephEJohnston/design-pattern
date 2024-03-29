package ch22_Command.command;

import ch22_Command.Drawable;
import java.awt.Point;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/11
 */
public class DrawCommand implements Command {
  protected Drawable drawable;
  private final Point position;

  public DrawCommand(Drawable drawable, Point position) {
    this.drawable = drawable;
    this.position = position;
  }

  @Override
  public void execute() {
    drawable.draw(position.x, position.y);
  }

  @Override
  public String toString() {
    return "draw: (" + position.x + "," + position.y + ")";
  }
}
