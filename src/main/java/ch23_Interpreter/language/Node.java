package ch23_Interpreter.language;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public abstract class Node implements Executor {
  public abstract void parse(Context context) throws ParseException;
}
