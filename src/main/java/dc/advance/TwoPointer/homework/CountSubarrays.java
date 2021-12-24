package dc.advance.TwoPointer.homework;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrays {

    public static void main(String[] args) {
/*        System.out.println(getSolve(new int[]{3, 2, 5, 2, 3}));
        System.out.println(getSolve(new int[]{1, 1, 3}));*/
   /*     System.out.println(discussion(new int[]{93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57,
                19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75,
                5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63}));*/
        System.out.println(getSolve(new int[]{93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57,
                19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75,
                5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63}));
  //      System.out.println(getSolve(new int[]{4, 5, 1, 2, 3, 1, 4, 5}));
        System.out.println("***********");
       /* System.out.println(discussion(new int[]{3, 2, 5, 2, 3}));
        System.out.println(discussion(new int[]{1, 1, 3}));
        System.out.println(discussion(new int[]{93, 9, 12, 32, 97, 75, 32, 77, 40, 79, 61, 42, 57,
                19, 64, 16, 86, 47, 41, 67, 76, 63, 24, 10, 25, 96, 1, 30, 73, 91, 70, 65, 53, 75,
                5, 19, 65, 6, 96, 33, 73, 55, 4, 90, 72, 83, 54, 78, 67, 56, 8, 70, 43, 63}));
        System.out.println(discussion(new int[]{4, 5, 1, 2, 3, 1, 4, 5}));*/
    }

    static int mod = 1000000007;

    public static int getSolve(int[] A) {

        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 1;
        map.put(A[0], 1);
        long res = 0;
        while (j < A.length) {
            if (!map.containsKey(A[j])) {
                map.put(A[j], 1);
            } else if (map.containsKey(A[j])) {
                long previous = findContribution(i, j - 1);
                res = (res + previous) % mod;
                System.out.println("res " + res);
                map.put(A[j], map.get(A[j]) + 1);
                if (map.get(A[j]) > 1) {
                    map.put(A[j], map.get(A[j]) - 1);
                    while (i < j) {
                        if (A[i] == A[j]) {
                            break;
                        }
                        map.remove(A[i]);
                        i++;
                    }
                    i++;
                }
                long next = findContribution(i, j - 1);
                System.out.println("next " + next);
                res = (res - next + mod) % mod;
                System.out.println("final  " + res);
            }
            if (j == A.length - 1) {
                long last = findContribution(i, j);
                res = (res + last) % mod;
            }
            j++;
        }

        return (int) (res % mod);
    }

    private static long findContribution(int i, int j) {
        long subArray = j - i + 1;
        return ((subArray * (subArray + 1)) / 2) % mod;
    }

}

/**
 con 21
 con 3
 con 435
 con 378
 con 435
 con 231
 con 253
 con 10
 con 253

 con 21
 con 3
 con 435
 con 378
 con 435
 con 231
 con 253
 con 10
 con 253
 */