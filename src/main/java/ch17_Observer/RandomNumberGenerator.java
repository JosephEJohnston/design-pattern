package ch17_Observer;

import java.util.Random;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/28
 */
public class RandomNumberGenerator extends NumberGenerator {
  private final Random random = new Random();
  private int number;

  @Override
  public int getNumber() {
    return number;
  }

  @Override
  public void execute() {
    for (int i = 0; i < 20; i++) {
      number = random.nextInt(50);
      notifyObservers();
    }
  }
}
