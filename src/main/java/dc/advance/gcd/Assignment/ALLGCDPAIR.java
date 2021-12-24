package dc.advance.gcd.Assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ALLGCDPAIR {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(new int[]{46, 1, 2, 1, 1, 1, 5, 45, 1, 1, 2, 5, 1, 40, 1, 1, 1, 1, 1, 1, 1, 1, 1, 31, 1})));
    }

    public static int[] getSolve(int[] A) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(A);
        int[] reverse = new int[A.length];
        int k = 0;
        int max = A[A.length - 1];
        for (int i = A.length - 1; i >= 0 && k < A.length; i--) {
            reverse[k] = A[i];
            k++;
        }
        int[] freq = new int[max + 1];
        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
        }
        //System.out.println(Arrays.toString(freq));
        for (int i = 0; i < reverse.length; i++) {
            if (freq[reverse[i]] > 0) {
                freq[reverse[i]]--;
                res.add(reverse[i]);
                System.out.println(res.toString());
                int j = 0;
                while (j < res.size() - 1) {
                    int val = gcd(reverse[i], res.get(j));
                    System.out.println("val:" + val);
                    freq[val] -= 2;
                    j++;
                }
                System.out.println(Arrays.toString(freq));
            }
        }
        System.out.println(Arrays.toString(freq));
        return res.stream().mapToInt(i -> i).toArray();
    }

    private static int gcd(int A, int B) {

        while (B > 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        //  System.out.println(A);
        return A;
    }
}
