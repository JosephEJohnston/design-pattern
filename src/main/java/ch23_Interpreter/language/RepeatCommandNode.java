package ch23_Interpreter.language;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */

// <repeat command> ::= repeat <number> <command list>
public class RepeatCommandNode extends Node {
  private int number;
  private Node commandListNode;

  @Override
  public void parse(Context context) throws ParseException {
    context.skipToken("repeat");
    number = context.currentNumber();
    context.nextToken();
    commandListNode = new CommandListNode();
    commandListNode.parse(context);
  }

  @Override
  public void execute() throws ExecuteException {
    for (int i = 0; i < number; i++) {
      commandListNode.execute();
    }
  }

  public String toString() {
    return "[repeat " + number + " " + commandListNode + "]";
  }
}
