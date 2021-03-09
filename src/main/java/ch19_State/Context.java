package ch19_State;

import ch19_State.state.State;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/04
 */
public interface Context {
  void setClock(int hour);
  void changeState(State state);
  void callSecurityCenter(String msg);
  void recordLog(String msg);
}
