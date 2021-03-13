package ch23_Interpreter.language;

/**
 *
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */

// <program> ::= program <command list>
public class ProgramNode extends Node {
  private Node commandListNode;

  @Override
  public void parse(Context context) throws ParseException {
    context.skipToken("program");
    commandListNode = new CommandListNode();
    commandListNode.parse(context);
  }

  @Override
  public void execute() throws ExecuteException {
    commandListNode.execute();
  }

  public String toString() {
    return "[program " + commandListNode + "]";
  }
}
