package ch21_Proxy;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/10
 */
public class Main {
  public static void main(String[] args) {
    Printable p = new PrinterProxy("Alice");
    System.out.println("现在的名字是" + p.getPrinterName() + "。");
    p.setPrinterName("Bob");
    System.out.println("现在的名字是" + p.getPrinterName() + "。");
    p.print("Hello, world.");
  }
}
