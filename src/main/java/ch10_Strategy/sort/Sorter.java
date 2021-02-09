package ch10_Strategy.sort;

public interface Sorter {
    <T> void sort(Comparable<T>[] data);
}
