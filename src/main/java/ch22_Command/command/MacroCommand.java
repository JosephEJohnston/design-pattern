package ch22_Command.command;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/11
 */
public class MacroCommand implements Command {
  private final Deque<Command> commands = new LinkedList<>();

  @Override
  public void execute() {
    for (Command command : commands) {
      command.execute();
      System.out.println(command);
    }
  }

  public void append(Command cmd) {
    if (cmd != this) {
      commands.push(cmd);
    }
  }

  public void undo() {
    if (!commands.isEmpty()) {
      commands.pop();
    }
  }

  public void clear() {
    commands.clear();
  }
}
