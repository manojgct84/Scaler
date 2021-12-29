package dc.advance.TwoPointer.reversion.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Sum3 {

    public static void main(String[] args) {
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(-1, 2, 1, -4)), 2));
        System.out.println(threeSumClosest(new ArrayList<>(Arrays.asList(1, 2, 3)), 6));
    }

    public static int threeSumClosest(ArrayList<Integer> A, int B) {
        int i = 0;
        Collections.sort(A);
        while (i < A.size()) {
            int j = i + 1;
            int k = A.size() - 1;
            int sum = A.get(i);
            while (j < k) {
                sum += A.get(j) + A.get(k);
                if (sum == B) {
                    return A.get(i) + A.get(j) + A.get(k);
                } else {
                    if (sum < B) {
                        j++;
                    } else {
                        k--;
                    }
                }
                sum = A.get(i);
            }
            i++;
        }
        return -1;
    }
}
