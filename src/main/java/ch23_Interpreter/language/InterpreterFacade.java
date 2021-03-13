package ch23_Interpreter.language;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/13
 */
public class InterpreterFacade implements Executor {
  private final ExecutorFactory factory;
  private Context context;
  private Node programNode;

  public InterpreterFacade(ExecutorFactory factory) {
    this.factory = factory;
  }

  public boolean parse(String text) {
    boolean ok = true;
    this.context = new Context(text);
    this.context.setExecutorFactory(factory);
    try {
      programNode.parse(context);
      System.out.println(programNode.toString());
    } catch (ParseException e) {
      e.printStackTrace();
      ok = false;
    }

    return ok;
  }

  @Override
  public void execute() throws ExecuteException {
    try {
      programNode.execute();
    } catch (ExecuteException e) {
      e.printStackTrace();
    }
  }
}
