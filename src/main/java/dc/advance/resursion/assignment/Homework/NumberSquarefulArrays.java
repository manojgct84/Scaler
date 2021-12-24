package dc.advance.resursion.assignment.Homework;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberSquarefulArrays {

    public static void main(String[] args) {
        NumberSquarefulArrays numberSquarefulArrays = new NumberSquarefulArrays();
        System.out.println(numberSquarefulArrays.getSolve(new int[]{2, 2, 2}));
        System.out.println(numberSquarefulArrays.getSolve(new int[]{1, 17, 8}));
        System.out.println(numberSquarefulArrays.getSolve(new int[]{1, 8, 8}));
        System.out.println(numberSquarefulArrays.getSolve(new int[]{2850, 286, 155}));
    }

    int prefectCount = 0;

    public int getSolve(int[] A) {
        if (A.length == 1) {
            return 0;
        }
        Arrays.sort(A);

        permutationsSquareFul(A, 0, new ArrayList<Integer>());
        return prefectCount;
    }

    private void
    permutationsSquareFul(int[] A, int index, ArrayList<Integer> temp) {
        if (index == A.length) {
            prefectCount++;
            return;
        }

        Set<Integer> freq = new HashSet<>();
        for (int i = index; i < A.length; ++i) {
            if (freq.contains(A[i])) {
                continue;
            }

            swap(A, i, index);
            //temp.add(A[i]);
            if (index == 0 || (isSqrtRoot(A[index] + /*temp.get(temp.size() - 1))*/  A[index - 1]))) {
                permutationsSquareFul(A, index + 1, temp);
            }
            swap(A, i, index); // undo step to previous call stack
            //temp.add(temp.size() - 1); // undo step to previous call stack
            freq.add(A[i]); // It is not prefSqrt or previously visited.
        }
    }

    private void swap(int[] a, int i, int index) {
        int temp = a[i];
        a[i] = a[index];
        a[index] = temp;
    }

    private boolean isSqrtRoot(int sqrtValue) {
        int x = (int) Math.sqrt(sqrtValue);
        return (x * x) == sqrtValue;
    }
}
