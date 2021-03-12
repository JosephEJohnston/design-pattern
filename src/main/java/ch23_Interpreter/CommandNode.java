package ch23_Interpreter;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public class CommandNode extends Node {
  private Node node;

  @Override
  public void parse(Context context) throws ParseException {
    if (context.currentToekn().equals("repeat")) {
      node = new RepeatCommandNode();
      node.parse(context);
    } else {
      node = new PrimitiveCommandNode();
      node.parse(context);
    }
  }

  public String toString() {
    return node.toString();
  }
}
