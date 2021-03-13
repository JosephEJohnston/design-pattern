package ch23_Interpreter.turtle;

import ch23_Interpreter.language.ExecuteException;
import ch23_Interpreter.language.Executor;
import ch23_Interpreter.language.ExecutorFactory;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/13
 */
public class TurtleCanvas extends Canvas implements ExecutorFactory {
  final static int UNIT_LENGTH = 30;
  final static int DIRECTION_UP = 0;
  final static int DIRECTION_RIGHT = 3;
  final static int DIRECTION_DOWN = 6;
  final static int DIRECTION_LEFT = 9;
  final static int RELATIVE_DIRECTION_RIGHT = 3;
  final static int RELATIVE_DIRECTION_LEFT = -3;
  final static int RADIUS = 3;

  private int direction = 0;
  private Point position;
  private Executor executor;
  public TurtleCanvas(int width, int height) {
    setSize(width, height);
    initialize();
  }

  public void setExecutor(Executor executor) {
    this.executor = executor;
  }

  void setRelativeDirection(int relativeDirection) {
    setDirection(direction + relativeDirection);
  }

  void setDirection(int direction) {
    if (direction < 0) {
      direction = 12 - (-direction) % 12;
    } else {
      direction = direction % 12;
    }
    this.direction = direction % 12;
  }

  void go(int length) {
    int newx = position.x;
    int newy = position.y;

    switch (direction) {
      case DIRECTION_UP:
        newx -= length;
        break;
      case DIRECTION_RIGHT:
        newx += length;
        break;
      case DIRECTION_DOWN:
        newy += length;
        break;
      case DIRECTION_LEFT:
        newy -= length;
        break;
      default:
        break;
    }

    Graphics g = getGraphics();
    if (g != null) {
      g.drawLine(position.x, position.y, newx, newy);
      g.fillOval(newx - RADIUS, newy - RADIUS,
          RADIUS * 2 + 1, RADIUS * 2 + 1);
    }

    position.x = newx;
    position.y = newy;
  }

  @Override
  public Executor createExecutor(String name) {
    switch (name) {
      case "go":
        return new GoExecutor(this);
      case "right":
        return new DirectionExecutor(this, RELATIVE_DIRECTION_RIGHT);
      case "left":
        return new DirectionExecutor(this, RELATIVE_DIRECTION_LEFT);
      default:
        return null;
    }
  }

  public void initialize() {
    Dimension size = getSize();
    position = new Point(size.width / 2, size.height / 2);
    direction = 0;
    setForeground(Color.RED);
    setBackground(Color.WHITE);
    Graphics g = getGraphics();
    if (g != null) {
      g.clearRect(0, 0, size.width, size.height);
    }
  }

  public void paint(Graphics g) {
    initialize();
    if (executor != null) {
      try {
        executor.execute();
      } catch (ExecuteException ignore) {
      }
    }
  }
}

abstract class TurTleExecutor implements Executor {
  protected TurtleCanvas canvas;
  public TurTleExecutor(TurtleCanvas canvas) {
    this.canvas = canvas;
  }

  public abstract void execute();
}

class GoExecutor extends TurTleExecutor {
  public GoExecutor(TurtleCanvas canvas) {
    super(canvas);
  }

  @Override
  public void execute() {
    canvas.go(TurtleCanvas.UNIT_LENGTH);
  }
}

class DirectionExecutor extends TurTleExecutor {
  private final int relativeDirection;

  public DirectionExecutor(TurtleCanvas canvas, int relativeDirection) {
    super(canvas);
    this.relativeDirection = relativeDirection;
  }

  @Override
  public void execute() {
    canvas.setRelativeDirection(relativeDirection);
  }
}