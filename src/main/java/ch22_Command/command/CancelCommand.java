package ch22_Command.command;

import ch22_Command.Drawable;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public class CancelCommand implements Command {
  protected Drawable drawable;

  public CancelCommand(Drawable drawable) {
    this.drawable = drawable;
  }

  @Override
  public void execute() {
    drawable.cancel();
  }

  @Override
  public String toString() {
    return "cancel";
  }
}
