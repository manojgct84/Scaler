package dc.clazz.Sorting.Assignment.HomeWork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StepwiseSelectionSort {

    public static void main(String[] args) {
        System.out.println((Arrays.toString(getSolution(new int[]{6, 4, 3, 7, 2, 8}))));
    }

    private static int[] getSolution(int[] A) {

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            int index = i;

            for (int j = i + 1; j < A.length; j++) {
                if (A[index] > A[j]) {
                    index = j;
                }
            }
            if (i < A.length - 1) {
                res.add(index);
            }
            int temp = A[i];
            A[i] = A[index];
            A[index] = temp;
        }

        return res.stream().mapToInt(i -> i).toArray();
    }
}
