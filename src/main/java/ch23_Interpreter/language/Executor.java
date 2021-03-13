package ch23_Interpreter.language;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/13
 */
public interface Executor {
  void execute() throws ExecuteException;
}
