package ch10_Strategy.sort;

public class Main {
    public static void main(String[] args) {
        String[] data = {
            "Dump", "Bowman", "Carroll", "Eland", "Alice",
        };

        //SortAndPrint<String> sap = new SortAndPrint<>(data, new SelectionSorter());
        SortAndPrint<String> sap = new SortAndPrint<>(data, new QuickSorter());
        sap.execute();
    }
}
