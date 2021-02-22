package ch16_Mediator;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/20
 */
public class LoginFrame extends Frame implements ActionListener, Mediator {
  private ColleagueCheckbox checkGuest;
  private ColleagueCheckbox checkLogin;
  private ColleagueTextField textUser;
  private ColleagueTextField textPass;
  private ColleagueButton buttonOk;
  private ColleagueButton buttonCancel;

  public LoginFrame(String title) {
    super(title);
    setBackground(Color.LIGHT_GRAY);
    setLayout(new GridLayout(4, 2));
    createColleagues();
    add(checkGuest);
    add(checkLogin);
    add(new Label("Username:"));
    add(textUser);
    add(new Label("Password:"));
    add(textPass);
    add(buttonOk);
    add(buttonCancel);
    colleagueChanged();
    pack();
    setVisible(true);
  }

  @Override
  public void createColleagues() {

  }

  @Override
  public void colleagueChanged() {

  }

  @Override
  public void actionPerformed(ActionEvent e) {

  }
}
