package ch23_Interpreter;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public class ProgramNode extends Node {
  private Node commandListNode;

  @Override
  public void parse(Context context) throws ParseException {
    context.skipToken("program");
    commandListNode = new CommandListNode();
    commandListNode.parse(context);
  }

  public String toString() {
    return "[program " + commandListNode + "]";
  }
}
