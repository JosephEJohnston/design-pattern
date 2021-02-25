package ch13_Visitor.visitor;

import ch13_Visitor.entry.Directory;
import ch13_Visitor.entry.ElementArrayList;
import ch13_Visitor.entry.File;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/25
 */
public class SizeVisitor extends Visitor {
  private int size;

  @Override
  public void visit(File file) {
    this.size = file.getSize();
  }

  @Override
  public void visit(Directory directory) {
    this.size = directory.getSize();
  }

  @Override
  public void visit(ElementArrayList list) {
    this.size = list.getSize();
  }

  public int getSize() {
    return size;
  }
}
