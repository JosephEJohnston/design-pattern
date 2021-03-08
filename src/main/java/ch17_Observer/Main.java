package ch17_Observer;

import ch17_Observer.generator.NumberGenerator;
import ch17_Observer.generator.RandomNumberGenerator;
import ch17_Observer.observer.DigitObserver;
import ch17_Observer.observer.GraphObserver;
import ch17_Observer.observer.Observer;

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
