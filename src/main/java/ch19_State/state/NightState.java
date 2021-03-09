package ch19_State.state;

import ch19_State.Context;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/04
 */
public class NightState implements State {
  private static final NightState singleton = new NightState();

  private NightState() {

  }

  public static State getInstance() {
    return singleton;
  }

  @Override
  public void doClock(Context context, int hour) {
    if (8 <= hour && hour < 21) {
      context.changeState(DayState.getInstance());
    }
  }

  @Override
  public void doUse(Context context) {
    context.callSecurityCenter("紧急：晚上使用金库！");
  }

  @Override
  public void doAlarm(Context context) {
    context.callSecurityCenter("按下警铃（晚上）");
    context.changeState(EmergencyState.getInstance());
  }

  @Override
  public void doPhone(Context context) {
    context.recordLog("晚上的通话录音");
  }

  public String toString() {
    return "[晚上]";
  }
}
