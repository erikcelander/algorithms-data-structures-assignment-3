package uppgift;

public class HybridQuickSort {
    public static void quickSort(int[] arr, int low, int high, int depth) {
        if (low < high) {
            if (depth == 0) {
                insertionSort(arr, low, high);
            } else {
                int pivotIndex = partition(arr, low, high);
                quickSort(arr, low, pivotIndex - 1, depth - 1);
                quickSort(arr, pivotIndex + 1, high, depth - 1);
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        int pivotIndex = medianOfThreeIndex(arr, low, mid, high);
        swap(arr, pivotIndex, high);
        int pivot = arr[high];
    
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    
    private static int medianOfThreeIndex(int[] arr, int a, int b, int c) {
        int x = arr[a] - arr[b];
        int y = arr[b] - arr[c];
        int z = arr[a] - arr[c];
        if (x * y > 0) return b;
        if (x * z > 0) return c;
        return a;
    }
    

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

   

 
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        quickSort(arr, 0, arr.length - 1, 3);
        for (int value : arr) {
            System.out.print(value + " ");
        }
    }    
}
