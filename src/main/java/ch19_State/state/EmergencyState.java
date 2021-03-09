package ch19_State.state;

import ch19_State.Context;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/09
 */
public class EmergencyState implements State {
  private static final EmergencyState singleton = new EmergencyState();
  private int period = 0;

  private EmergencyState() {

  }

  public static State getInstance() {
    return singleton;
  }

  @Override
  public void doClock(Context context, int hour) {
    period++;
    if (period >= 5) {
      if (hour < 8 || 21 <= hour) {
        context.changeState(NightState.getInstance());
      } else if (hour == 12) {
        context.changeState(LunchState.getInstance());
      } else {
        context.changeState(DayState.getInstance());
      }
      period = 0;
    }
  }

  @Override
  public void doUse(Context context) {
    context.callSecurityCenter("使用金库（紧急）");
  }

  @Override
  public void doAlarm(Context context) {
    context.callSecurityCenter("按下警铃（紧急）");
    period = 0;
  }

  @Override
  public void doPhone(Context context) {
    context.callSecurityCenter("使用电话（紧急）");
  }
}
