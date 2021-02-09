package ch13_Visitor.entry;


import ch13_Visitor.visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Directory extends Entry {
    private String name;
    private List<Entry> dir = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        int size = 0;
        for (Entry entry : dir) {
            size += entry.getSize();
        }

        return size;
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

    public Entry add(Entry entry) {
        dir.add(entry);
        return this;
    }

    public Iterator<Entry> iterator() {
        return dir.iterator();
    }
}
