package ch23_Interpreter.language;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */

// <command> ::= <repeat command> | <primitive command>
public class CommandNode extends Node {
  private Node node;

  @Override
  public void parse(Context context) throws ParseException {
    if (context.currentToken().equals("repeat")) {
      node = new RepeatCommandNode();
    } else {
      node = new PrimitiveCommandNode();
    }
    node.parse(context);
  }

  @Override
  public void execute() throws ExecuteException {
    node.execute();
  }

  public String toString() {
    return node.toString();
  }
}
