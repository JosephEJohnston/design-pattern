package ch22_Command.command;

import ch22_Command.DrawCanvas;
import java.awt.Color;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public class ColorCommand implements Command {
  private final DrawCanvas canvas;
  // todo zeyuan，bug 原因：canvas 取消时的颜色和原来不一样
  private final Color color;

  public ColorCommand(DrawCanvas canvas, Color color) {
    this.canvas = canvas;
    this.color = color;
  }

  @Override
  public void execute() {
    canvas.setColor(color);
  }

  @Override
  public String toString() {
    return "set color: " + color;
  }
}
