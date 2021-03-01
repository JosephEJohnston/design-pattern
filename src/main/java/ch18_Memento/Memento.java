package ch18_Memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/01
 */
public class Memento {
  int money;
  ArrayList<String> fruits;

  public int getMoney() {
    return money;
  }

  Memento(int money) {
    this.money = money;
    this.fruits = new ArrayList<>();
  }

  void addFruit(String fruit) {
    fruits.add(fruit);
  }

  List<String> getFruits() {
    return (List<String>) fruits.clone();
  }
}
