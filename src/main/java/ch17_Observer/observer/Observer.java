package ch17_Observer.observer;

import ch17_Observer.generator.NumberGenerator;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/28
 */
public interface Observer {
  void update(NumberGenerator generator);
}
