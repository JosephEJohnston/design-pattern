package ch17_Observer;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/28
 */
public interface Observer {
  void update(NumberGenerator generator);
}
