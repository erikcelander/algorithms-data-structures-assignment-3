package uppgift.uppgift1;

import java.util.List;

public class QuickSort {

    private void quickSort(List<Integer> list, int low, int high, int depth) {
        if (low < high) {
            if (depth == 0) {
                insertionSort(list, low, high);
            } else {
                int pivotIndex = partition(list, low, high);
                quickSort(list, low, pivotIndex - 1, depth - 1);
                quickSort(list, pivotIndex + 1, high, depth - 1);
            }
        }
    }

    private int partition(List<Integer> list, int low, int high) {
        medianOfThree(list, low, high);
        int pivot = list.get(low);
        int i = low;
        int j = high + 1;
        while (true) {
            while (list.get(++i) < pivot) {
                if (i == high) break;
            }
            while (list.get(--j) > pivot) {
                if (j == low) break;
            }
            if (i >= j) break;
            swap(list, i, j);
        }
        swap(list, low, j);
        return j;
    }

    private void medianOfThree(List<Integer> list, int low, int high) {
        int middle = low + (high - low) / 2;
        if (list.get(low) > list.get(middle)) swap(list, low, middle);
        if (list.get(low) > list.get(high)) swap(list, low, high);
        if (list.get(middle) > list.get(high)) swap(list, middle, high);
        swap(list, low, middle);
    }

    private void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    private void insertionSort(List<Integer> list, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int value = list.get(i);
            int j = i - 1;
            while (j >= low && list.get(j) > value) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, value);
        }
    }

    public void sort(List<Integer> list, int depth) {
        if (list == null || list.size() <= 1) return;
        quickSort(list, 0, list.size() - 1, depth);
    }
}