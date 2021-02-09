package ch10_Strategy.sort;

public class QuickSorter implements Sorter {
    @Override
    public <T> void sort(Comparable<T>[] data) {
        quickSort(data, 0, data.length - 1);
    }

    public <T> void quickSort(Comparable<T>[] data, int pivot, int right) {
        if (pivot < right) {
            int parting = partition(data, pivot, right);

            quickSort(data, pivot, parting - 1);
            quickSort(data, parting + 1, right);
        }
    }

    private <T> int partition(Comparable<T>[] data, int pivot, int right) {
        Comparable<T> x = data[right];
        int i = pivot - 1;
        for (int j = pivot; j < right; j++) {
            if (data[j].compareTo((T)x) <= 0) {
                i = i + 1;

                Comparable<T> tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }

        Comparable<T> tmp = data[i + 1];
        data[i + 1] = data[right];
        data[right] = tmp;

        return i + 1;
    }
}
