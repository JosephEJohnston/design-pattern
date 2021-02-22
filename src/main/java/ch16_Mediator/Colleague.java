package ch16_Mediator;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/20
 */
public interface Colleague {
  void setMediator(Mediator mediator);
  void setColleagueEnabled(boolean enabled);
}
