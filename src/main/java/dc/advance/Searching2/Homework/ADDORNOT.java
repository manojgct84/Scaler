package dc.advance.Searching2.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ADDORNOT {

    public static void main(String[] args) {
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(3, 1, 2, 2, 1)), 3));
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(5, 5, 5)), 3));
    }

    public static ArrayList<Integer> getSolve(ArrayList<Integer> A, int B) {
        Collections.sort(A);

        int[] pref = new int[A.size() + 1];
        pref[0] = 0;
        pref[1] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            pref[i + 1] = A.get(i) + pref[i];
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        res.add(-1);
        for (int i = 0; i < A.size(); i++) {
            int low = 1;
            int high = i + 1;
            int max = 0;
            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                if (check(mid, B, A, i, pref)) {
                    max = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (res.get(0) < max) {
                res.set(0, max);
                res.set(1, A.get(i));
            }
        }
        return res;
    }

    private static boolean check(int mid, int b, ArrayList<Integer> a, int i, int[] pref) {
        int val = (a.get(i) * mid);
        int pre = pref[i + 1] - pref[i - mid + 1];
        return ((val - pre) <= b);

     /*   while(end <= len) {
            while(sum > k && start < end-1)
            {
               sum = sum - arr[start]; start++;
            }
            if(sum == k)
            {
                return new int[] {start, end-1};
             }
             if(end < len)
                sum = sum + arr[end]; end++; }*/
    }
}
