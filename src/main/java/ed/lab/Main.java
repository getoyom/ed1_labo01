package ed.lab;
import java.util.Arrays;
import java.util.Random;


public class Main {
    private static final ArrayGenerator<String> sortedArrayGenerator = (length)-> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = "a";
        }
        Arrays.sort(array);
        return array;
    };

    private static final ArrayGenerator<String> invertedArrayGenerator = (length)-> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            array[i] = "a";
        }
        Arrays.sort(array);
        for (int i = 0; i < array.length/2; i++) {
            int j = array.length-i-1;
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    };

    private static final ArrayGenerator<String> randomArrayGenerator =  (length)-> {
        String[] array = new String[length];
        for (int i = 0; i < length; i++) {
            Random random = new Random();
            String letter = String.valueOf((char) (random.nextInt(26) + 'a'));
            array[i] = letter;
        }
        return array;
    };

    private static final QuickSort<String> highPivotQuickSort = array -> SortingAlgorithms.highPivotQuickSort(array,0,array.length-1);

    private static final QuickSort<String> lowPivotQuickSort = array -> SortingAlgorithms.lowPivotQuickSort(array,0,array.length-1);

    private static final QuickSort<String> randomPivotQuickSort = array -> SortingAlgorithms.randomPivotQuickSort(array,0,array.length-1);

    public static QuickSort<String> getHighPivotQuickSort() {
        return highPivotQuickSort;
    }

    public static QuickSort<String> getLowPivotQuickSort() {
        return lowPivotQuickSort;
    }

    public static QuickSort<String> getRandomPivotQuickSort() {
        return randomPivotQuickSort;
    }

    public static ArrayGenerator<String> getSortedArrayGenerator() {
        return sortedArrayGenerator;
    }

    public static ArrayGenerator<String> getInvertedArrayGenerator() {
        return invertedArrayGenerator;
    }

    public static ArrayGenerator<String> getRandomArrayGenerator() {
        return randomArrayGenerator;
    }

    public static void main(String[] args) {
        final SortingTester<String> tester = new SortingTester<>();

        System.out.println("Ordenando un arreglo ordenado:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo invertido:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");

        System.out.println("Ordenando un arreglo aleatorio:");
        System.out.println("\tUtilizando el último elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        System.out.println("\tUtilizando el primer elemento como pivote: ");
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        System.out.println("\tUtilizando un elemento aleatorio como pivote: ");
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
        System.out.println("================================");
    }
}