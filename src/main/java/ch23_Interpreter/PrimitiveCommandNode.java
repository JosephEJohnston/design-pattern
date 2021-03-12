package ch23_Interpreter;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public class PrimitiveCommandNode extends Node {
  private String name;

  @Override
  public void parse(Context context) throws ParseException {
    name = context.currentToekn();
    context.skipToken(name);
    if (!name.equals("go") && !name.equals("right")
        && !name.equals("left")) {
      throw new ParseException(name + " is undefined");
    }
  }

  public String toString() {
    return name;
  }
}
