package dc.advance.TwoPointer.reversion.assignment;

import java.util.ArrayList;
import java.util.Arrays;

public class SubarrayWithGivenSum {

    public static void main(String[] args) {
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5)), 5));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(5, 10, 20, 100, 105)), 110));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(15, 2, 48, 19, 28, 22, 44, 2,
                32, 46, 46, 24, 1, 23, 49, 26, 23, 17, 17, 46, 4, 30, 40, 36, 20, 5)), 82));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(23, 50, 44, 6, 39, 15, 44, 27, 47, 29, 30, 44, 28, 42, 7, 32, 16, 40, 8, 7, 5, 48, 48, 16
                , 9, 5, 50, 16, 18, 9, 21, 26, 48, 37, 27, 7, 5, 29, 24, 28, 10, 44, 21, 1, 48,
                15, 31, 41, 42, 23, 4, 32, 40, 40, 27, 20, 29, 42, 25, 18, 37, 43, 13, 30, 42, 24
                , 17, 42, 14, 42, 43, 36, 31, 29, 24, 24, 8, 3, 12, 34, 14, 6)), 62));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 1000000000)), 1000000000));

    }

    public static ArrayList<Integer> getSolve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int sum = A.get(i);
        while (j < A.size()) {
            if (sum == B) {
                int k = i;
                while (k <= j) {
                    res.add(A.get(k));
                    k++;
                }
                return res;
            } else if (sum < B) {
                j++;
                if (j < A.size()) {
                    sum += A.get(j);
                }
            } else {
                sum -= A.get(i);
                i++;
                if (i > j && i < A.size()) {
                    j++;
                    sum += A.get(j);
                }
            }
        }
        res.add(-1);
        return res;
    }

    public static ArrayList<Integer> getDifferentSolve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        int sum = 0;
        while (j < A.size()) {
            sum += A.get(j);
            while (sum > B && i < j) {
                sum -= A.get(i);
                i++;
            }
            if (sum == B) {
                int k = i;
                while (k <= j) {
                    res.add(A.get(k));
                    k++;
                }
                i = k;
            }
            j++;
        }
        if (res.size() > 0) return res;
        else res.add(-1);
        return res;
    }
}
