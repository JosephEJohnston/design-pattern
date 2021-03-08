package ch17_Observer.observer;

import ch17_Observer.generator.NumberGenerator;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/08
 */
public class ConcreteObserver implements Observer {

  @Override
  public void update(NumberGenerator generator) {
    System.out.println("啥也不做");
  }
}
