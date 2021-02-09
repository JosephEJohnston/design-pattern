package ch13_Visitor.visitor;

public interface Element {
    void accept(Visitor v);
}
