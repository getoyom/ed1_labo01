package ed.lab;


public class SortingAlgorithms {
    //QuickSort using high pivot
    public static <T extends Comparable<T>> int partitionHigh(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) { // arr[j] < pivot
                i++;
                // swap arr[i] and arr[j]
                swap(arr, i, j);
            }
        }
        i++;
        // swap arr[i] and arr[high] (pivot)
        swap(arr, i, high);
        return i;
    }

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivot = partitionHigh(arr, low, high);

            highPivotQuickSort(arr, low, pivot - 1);
            highPivotQuickSort(arr, pivot + 1, high);
        }
    }

    //QuickSort using low pivot
    public static <T extends Comparable<T>> int partitionLow(T[] arr, int low, int high) {
        T pivotLow = arr[low];
        int i = low;

        for (int j = low+1; j <= high; j++) {
            if (arr[j].compareTo(pivotLow) < 0) { // arr[j] < pivot
                i++;
                // swap arr[i] y arr[j]
                swap(arr, i, j);
            }
        }
        // swap arr[low] and arr[i]
        swap(arr, low, i);
        return i;
    }

    static<T extends Comparable<T>>void lowPivotQuickSort(T[] arr, int low, int high){

        if (low < high) {
            int pivot = partitionLow(arr, low, high);

            highPivotQuickSort(arr, low, pivot - 1);
            highPivotQuickSort(arr, pivot + 1, high);
        }
    }

    //QuickSort using random pivot
    public static <T extends Comparable<T>> int partitionRandom(T[] arr, int low, int high) {
        int randIndex = low + (int) (Math.random() * (high - low + 1));
        swap(arr, randIndex, high);
        T pivotRand = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivotRand) < 0) { // arr[j] < pivot
                i++;
                // swap arr[i] y arr[j]
                swap(arr, i, j);
            }
        }
        i++;
        // swap arr[i] and arr[high] (pivot random switching position with high value)
        swap(arr, i, high);
        return i;
    }

    static<T extends Comparable<T>>void randomPivotQuickSort(T[] arr, int low, int high){
        if (low < high) {
            int pivot = partitionRandom(arr, low, high);

            highPivotQuickSort(arr, low, pivot - 1);
            highPivotQuickSort(arr, pivot + 1, high);
        }
    }

    //Method swap to have clean code!
    private static <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}




