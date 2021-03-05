package ch19_State;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/04
 */
public interface State {
  void doClock(Context context, int hour);
  void doUse(Context context);
  void doAlarm(Context context);
  void doPhone(Context context);
}
