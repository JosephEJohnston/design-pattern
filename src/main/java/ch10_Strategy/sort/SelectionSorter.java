package ch10_Strategy.sort;

public class SelectionSorter implements Sorter {
    @Override
    public <T> void sort(Comparable<T>[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[min].compareTo((T)data[j]) > 0) {
                    min = j;
                }
            }
            Comparable<T> passingPlace = data[min];
            data[min] = data[i];
            data[i] = passingPlace;
        }
    }
}
