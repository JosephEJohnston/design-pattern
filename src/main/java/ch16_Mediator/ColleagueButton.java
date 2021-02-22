package ch16_Mediator;

import java.awt.Button;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/20
 */
public class ColleagueButton extends Button implements Colleague {
  private Mediator mediator;
  public ColleagueButton(String caption) {
    super(caption);
  }

  @Override
  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void setColleagueEnabled(boolean enabled) {
    setEnabled(enabled);
  }
}
