package ch23_Interpreter;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
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

  public String toString() {
    return "[repeat " + number + " " + commandListNode + "]";
  }
}
