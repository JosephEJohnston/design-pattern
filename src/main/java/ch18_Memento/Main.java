package ch18_Memento;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/01
 */
public class Main {
  public static void main(String[] args) throws ClassNotFoundException {
    int money = 100;
    try (ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("game.dat")));) {

      Memento lastMemento = (Memento)in.readObject();
      if (lastMemento != null) {
        money = lastMemento.getMoney();
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("没有找到对象");
    }


    Gamer gamer = new Gamer(money);
    Memento memento = gamer.createMemento();

    for (int i = 0; i < 10; i++) {
      System.out.println("==== " + i);
      System.out.println("当前状态：" + gamer);

      gamer.bet();

      System.out.println("所持金钱为" + gamer.getMoney() + "元。");

      if (gamer.getMoney() > memento.getMoney()) {
        System.out.println("（所持进去增加了许多，因此保存游戏当前的状态）");
        memento = gamer.createMemento();
      } else if (gamer.getMoney() < memento.getMoney() / 2) {
        System.out.println("（所持金钱减少了许多，因此将游戏恢复至以前的状态）");
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException ignored) {
      }
      System.out.println();
    }

    if (memento.getMoney() > 100) {
      try (ObjectOutputStream out = new ObjectOutputStream(
          new BufferedOutputStream(
              new FileOutputStream("game.dat")))) {

        out.writeObject(memento);

        out.flush();
      } catch (IOException e) {
        e.printStackTrace();
      }

    }
  }
}
