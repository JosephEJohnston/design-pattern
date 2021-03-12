package ch23_Interpreter;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public abstract class Node {
  public abstract void parse(Context context) throws ParseException;
}
