package ch17_Observer.generator;

import ch17_Observer.observer.Observer;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/28
 */
public abstract class NumberGenerator {
  private final List<Observer> observers = new ArrayList<>();
  public void addObserver(Observer observer) {
    observers.add(observer);
  }

  public void deleteObserver(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update(this);
    }
  }

  public abstract int getNumber();
  public abstract void execute();
}
