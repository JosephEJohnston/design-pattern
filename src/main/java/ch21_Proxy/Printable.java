package ch21_Proxy;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/03/10
 */
public interface Printable {
  void setPrinterName(String name);
  String getPrinterName();
  void print(String string);
}
