package ch6_Prototype;

public interface Product extends Cloneable {
    void use(String s);
    Product createClone();
}
