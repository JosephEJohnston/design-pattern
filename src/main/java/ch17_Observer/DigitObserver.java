package ch17_Observer;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/28
 */
public class DigitObserver implements Observer {

  @Override
  public void update(NumberGenerator generator) {
    System.out.println("DigitObserver:" + generator.getNumber());
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
