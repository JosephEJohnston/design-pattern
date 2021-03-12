package ch23_Interpreter;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/12
 */
public class Main {
  public static void main(String[] args) {
    try (BufferedReader reader = new BufferedReader(new FileReader("program.txt"))) {
      String text;

      while ((text = reader.readLine()) != null) {
        System.out.println("text = \"" + text + "\"");
        Node node = new ProgramNode();
        node.parse(new Context(text));
        System.out.println("node = " + node);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
