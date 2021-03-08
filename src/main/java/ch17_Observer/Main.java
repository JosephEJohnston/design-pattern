package ch17_Observer;

import ch17_Observer.generator.IncrementalNumberGenerator;
import ch17_Observer.generator.NumberGenerator;
import ch17_Observer.observer.ConcreteObserver;
import ch17_Observer.observer.DigitObserver;
import ch17_Observer.observer.GraphObserver;
import ch17_Observer.observer.Observer;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/28
 */
public class Main {
  public static void main(String[] args) {
//    NumberGenerator generator = new RandomNumberGenerator();
    NumberGenerator generator = new IncrementalNumberGenerator(10, 50, 5);
    Observer observer1 = new DigitObserver();
    Observer observer2 = new GraphObserver();
    Observer observer3 = new ConcreteObserver();
    generator.addObserver(observer1);
    generator.addObserver(observer2);
    generator.addObserver(observer3);
    generator.execute();
  }
}
