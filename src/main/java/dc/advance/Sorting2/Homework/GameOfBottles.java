package dc.advance.Sorting2.Homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GameOfBottles {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{6, 4, 2, 1}));
        // System.out.println(getSolve(new int[]{1, 1}));
        // System.out.println(getSolve(new int[]{8, 15, 1, 10, 5, 19, 19, 3, 5, 6, 6, 2, 8, 2, 12, 16,
        //         3, 8, 17, 12, 5, 3, 14, 13, 3, 2, 17, 19, 16, 8, 7, 12, 19, 10, 13, 8, 20, 16, 15, 4, 12, 3}));
    }

    public static int getSolve(int[] A) {
        //Arrays.sort(A);
        quickSort(A, 0, A.length - 1);

        System.out.println(Arrays.toString(A));

        Map<Integer, Integer> map = new HashMap<>();
        for (int j : A) {
            map.put(j, map.getOrDefault(j, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(entry.getValue(), max);
        }
        return max;
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partition(a, low, high);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    private static int partition(int[] a, int low, int high) {
        int pi = a[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (a[j] < pi) {
                i++;
                swapValue(a, i, j);
            }
        }
        swapValue(a, i + 1, high);
        return (i + 1);
    }

    private static void swapValue(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
