package ch17_Observer;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/28
 */
public class Main {
  public static void main(String[] args) {
    NumberGenerator generator = new RandomNumberGenerator();
    Observer observer1 = new DigitObserver();
    Observer observer2 = new GraphObserver();
    generator.addObserver(observer1);
    generator.addObserver(observer2);
    generator.execute();
  }
}
