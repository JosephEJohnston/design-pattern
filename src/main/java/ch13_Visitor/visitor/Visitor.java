package ch13_Visitor.visitor;


import ch13_Visitor.entry.Directory;
import ch13_Visitor.entry.ElementArrayList;
import ch13_Visitor.entry.File;

public abstract class Visitor {
    public abstract void visit(File file);
    public abstract void visit(Directory directory);
    public abstract void visit(ElementArrayList list);
}
