package ch13_Visitor.entry;

import ch13_Visitor.FileTreatmentException;
import ch13_Visitor.visitor.Visitor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Zeyuan Wang[wangzeyuan@nowcoder.com]
 * @date 2021/02/25
 */
public class ElementArrayList extends Entry {
  private List<Entry> list = new ArrayList<>();

  @Override
  public String getName() {
    throw new FileTreatmentException();
  }

  @Override
  public int getSize() {
    return list.stream()
        .mapToInt(Entry::getSize)
        .sum();
  }

  @Override
  public void accept(Visitor v) {
    v.visit(this);
  }

  public Entry add(Entry entry) {
    list.add(entry);
    return this;
  }

  public Iterator<Entry> iterator() {
    return list.iterator();
  }
}
