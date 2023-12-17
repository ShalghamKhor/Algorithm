package assignment2.task4;

public class HeapSort {

    public void heapSort(int[] array, int low, int high) {
        for (int i = high / 2 - 1; i >= low; i--) {
            heapify(array, high, i);
        }
        for (int i = high; i >= low; i--) {
            int temp = array[low];
            array[low] = array[i];
            array[i] = temp;
            heapify(array, i, low);
        }
    }

    public void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

}
