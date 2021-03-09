package ch19_State.state;

import ch19_State.Context;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/09
 */
public class LunchState implements State {
  private static final LunchState singleton = new LunchState();

  private LunchState() {

  }

  public static State getInstance() {
    return singleton;
  }

  @Override
  public void doClock(Context context, int hour) {
    if (!(hour == 12)) {
      context.changeState(DayState.getInstance());
    }
  }

  @Override
  public void doUse(Context context) {
    context.callSecurityCenter("使用金库（午餐）");
  }

  @Override
  public void doAlarm(Context context) {
    context.callSecurityCenter("按下警铃（午餐）");
    context.changeState(EmergencyState.getInstance());
  }

  @Override
  public void doPhone(Context context) {
    context.callSecurityCenter("正常通话（午餐）");
  }

  public String toString() {
    return "[午餐]";
  }
}
