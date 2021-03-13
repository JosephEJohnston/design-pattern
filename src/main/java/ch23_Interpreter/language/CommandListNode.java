package ch23_Interpreter.language;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public class CommandListNode extends Node {
  private final List<Node> list = new ArrayList<>();

  @Override
  public void parse(Context context) throws ParseException {
    while (true) {
      if (context.currentToken() == null) {
        throw new ParseException("Missing 'end'");
      } else if (context.currentToken().equals("end")) {
        context.skipToken("end");
        break;
      } else {
        Node commandNode = new CommandNode();
        commandNode.parse(context);
        list.add(commandNode);
      }
    }
  }

  @Override
  public void execute() throws ExecuteException {
    for (Node node : list) {
      node.execute();
    }
  }

  public String toString() {
    return list.toString();
  }
}
