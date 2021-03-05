package ch19_State;

import java.awt.Button;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/04
 */
public class SafeFrame extends Frame implements ActionListener, Context {
  private TextField textClock = new TextField(60);
  private TextArea textScreen = new TextArea(10, 60);
  private Button buttonUse = new Button("使用金库");
  private Button buttonAlarm = new Button("按下警铃");
  private Button buttonPhone = new Button("正常通话");
  private Button buttonExit = new Button("结束");

  private State state = DayState.getInstance();

  @Override
  public void setClock(int hour) {

  }

  @Override
  public void changeState(State state) {

  }

  @Override
  public void callSecurityCenter(String msg) {

  }

  @Override
  public void recordLog(String msg) {

  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
