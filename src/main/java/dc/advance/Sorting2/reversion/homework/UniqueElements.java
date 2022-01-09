package dc.advance.Sorting2.reversion.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//TC : O(nlogn)
public class UniqueElements {

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(1, 1, 3))));
        System.out.println(solve(new ArrayList<>(Arrays.asList(2, 4, 5))));
        System.out.println(solve(new ArrayList<>(Arrays.asList(51, 6, 10, 8, 22, 61, 56, 48, 88, 85,
                21, 98, 81, 76,
                71, 68, 18, 6, 14, 23, 72, 18, 56, 30, 97, 100, 81, 5, 99, 2, 85, 67, 46, 32, 66,
                51, 76, 53, 36, 31, 81, 56, 26, 75, 69, 54, 54, 54, 83, 41, 86, 48, 7, 32, 85, 23,
                47, 23, 18, 45, 79, 95, 73, 15, 55, 16, 66, 73, 13, 85, 14, 80, 39, 92, 66, 20, 22,
                25, 34, 14, 51, 14, 17, 10, 100, 35, 9, 83, 31, 60, 24, 37, 69, 62))));
    }

    public static int solve(ArrayList<Integer> A) {
        int count = 0;
        Collections.sort(A);
        for (int i = 1; i < A.size(); i++) {
             if (A.get(i) <= A.get(i - 1)){
                int val = A.get(i - 1);
                count = count + val + 1 - A.get(i);
                A.set(i, (val + 1));
            }
        }
        return count;
    }
}
