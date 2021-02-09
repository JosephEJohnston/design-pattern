package ch10_Strategy.sort;

public class SortAndPrint<T> {
    Comparable<T>[] data;
    Sorter sorter;

    public SortAndPrint(Comparable<T>[] data, Sorter sorter) {
        this.data = data;
        this.sorter = sorter;
    }

    public void execute() {
        print();
        sorter.sort(data);
        print();
    }

    public void print() {
        for (Comparable<T> datum : data) {
            System.out.print(datum + ", ");
        }
        System.out.println();
    }
}
