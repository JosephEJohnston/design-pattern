package ch13_Visitor.visitor;

import ch13_Visitor.entry.Directory;
import ch13_Visitor.entry.ElementArrayList;
import ch13_Visitor.entry.Entry;
import ch13_Visitor.entry.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/25
 */
public class FileFindVisitor extends Visitor {
  private final List<File> fileFindList;
  private final String suffix;

  public FileFindVisitor(String suffix) {
    this.suffix = suffix;
    this.fileFindList = new ArrayList<>();
  }

  @Override
  public void visit(File file) {
    if (endWithSuffix(file)) {
      fileFindList.add(file);
    }
  }

  @Override
  public void visit(Directory directory) {
    visitContent(directory.iterator());
  }

  @Override
  public void visit(ElementArrayList list) {
    visitContent(list.iterator());
  }

  private void visitContent(Iterator<Entry> iterator) {
    while (iterator.hasNext()) {
      Entry entry = iterator.next();
      if (entry instanceof File &&
          endWithSuffix((File) entry)) {
        fileFindList.add((File) entry);
      } else if (entry instanceof Directory) {
        entry.accept(this);
      } else if (entry instanceof ElementArrayList) {
        entry.accept(this);
      }
    }
  }

  private boolean endWithSuffix(File file) {
    return file.getName().endsWith(suffix);
  }

  public Iterator<File> getFoundFiles() {
    return fileFindList.iterator();
  }
}
