package ch19_State.state;

import ch19_State.Context;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/04
 */
public class DayState implements State {
  private static final DayState singleton = new DayState();

  private DayState() {

  }

  public static State getInstance() {
    return singleton;
  }

  @Override
  public void doClock(Context context, int hour) {
    if (hour < 8 || 21 <= hour) {
      context.changeState(NightState.getInstance());
    } else if (hour == 12) {
      context.changeState(LunchState.getInstance());
    }
  }

  @Override
  public void doUse(Context context) {
    context.recordLog("使用金库（白天）");
  }

  @Override
  public void doAlarm(Context context) {
    context.callSecurityCenter("按下警铃（白天）");
    context.changeState(EmergencyState.getInstance());
  }

  @Override
  public void doPhone(Context context) {
    context.callSecurityCenter("正常通话（白天）");
  }

  public String toString() {
    return "[白天]";
  }
}
