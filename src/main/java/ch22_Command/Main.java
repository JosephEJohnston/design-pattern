package ch22_Command;

import ch22_Command.command.CancelCommand;
import ch22_Command.command.ColorCommand;
import ch22_Command.command.Command;
import ch22_Command.command.DrawCommand;
import ch22_Command.command.MacroCommand;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/11
 */
public class Main extends JFrame
    implements ActionListener, MouseMotionListener, WindowListener {
  private final MacroCommand history = new MacroCommand();
  private final DrawCanvas canvas = new DrawCanvas(400, 400, this.history);
  private final JButton clearButton = new JButton("clear");
  private final JButton cancelButton = new JButton("cancel");
  private final JButton colorRedButton = new JButton("color.red");
  private final JButton colorYellowButton = new JButton("color.yellow");

  public Main(String title) {
    super(title);

    this.addWindowListener(this);
    canvas.addMouseMotionListener(this);
    clearButton.addActionListener(this);
    cancelButton.addActionListener(this);
    colorRedButton.addActionListener(this);
    colorYellowButton.addActionListener(this);

    Box buttonBox = new Box(BoxLayout.X_AXIS);
    buttonBox.add(clearButton);
    buttonBox.add(cancelButton);
    buttonBox.add(colorRedButton);
    buttonBox.add(colorYellowButton);
    Box mainBox = new Box(BoxLayout.Y_AXIS);
    mainBox.add(buttonBox);
    mainBox.add(canvas);
    getContentPane().add(mainBox);

    pack();
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == clearButton) {
      history.clear();
      canvas.repaint();
    } else if (e.getSource() == cancelButton) {
      Command cancelCommand = new CancelCommand(canvas);
      cancelCommand.execute();
    } else if (e.getSource() == colorRedButton) {
      Command colorCommand = new ColorCommand(canvas, Color.RED);
      history.append(colorCommand);
      colorCommand.execute();
    } else if (e.getSource() == colorYellowButton) {
      Command colorCommand = new ColorCommand(canvas, Color.YELLOW);
      history.append(colorCommand);
      colorCommand.execute();
    }
  }

  @Override
  public void mouseMoved(MouseEvent e) {
  }

  @Override
  public void mouseDragged(MouseEvent e) {
    Command cmd = new DrawCommand(canvas, e.getPoint());
    history.append(cmd);
    cmd.execute();
  }

  @Override
  public void windowClosing(WindowEvent e) {
    System.exit(0);
  }

  @Override
  public void windowOpened(WindowEvent e) { }
  @Override
  public void windowClosed(WindowEvent e) { }
  @Override
  public void windowIconified(WindowEvent e) { }
  @Override
  public void windowDeiconified(WindowEvent e) { }
  @Override
  public void windowActivated(WindowEvent e) { }
  @Override
  public void windowDeactivated(WindowEvent e) { }

  public static void main(String[] args) {
    new Main("Command Pattern Sample");
  }
}
