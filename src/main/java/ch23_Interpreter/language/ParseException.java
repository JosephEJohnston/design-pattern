package ch23_Interpreter.language;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public class ParseException extends Exception {
  public ParseException(String msg) {
    super(msg);
  }
}
