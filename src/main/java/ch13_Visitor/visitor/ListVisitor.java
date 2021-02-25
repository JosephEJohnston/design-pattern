package ch13_Visitor.visitor;

import ch13_Visitor.entry.Directory;
import ch13_Visitor.entry.ElementArrayList;
import ch13_Visitor.entry.Entry;
import ch13_Visitor.entry.File;

import java.util.Iterator;

public class ListVisitor extends Visitor {
    private String currentDir = "";

    @Override
    public void visit(File file) {
        System.out.println(currentDir + "/" + file);
    }

    @Override
    public void visit(Directory directory) {
        System.out.println(currentDir + "/" + directory);
        String saveDir = currentDir;
        currentDir = currentDir + "/" + directory.getName();
        Iterator<Entry> it = directory.iterator();
        while (it.hasNext()) {
            Entry entry = it.next();
            entry.accept(this);
        }
        currentDir = saveDir;
    }

    @Override
    public void visit(ElementArrayList list) {
        Iterator<Entry> iterator = list.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            entry.accept(this);
        }
    }
}
