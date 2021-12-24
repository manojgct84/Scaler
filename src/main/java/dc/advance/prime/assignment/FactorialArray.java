package dc.advance.prime.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FactorialArray {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{2, 3, 4}));
    }


    public static int getSolve(int[] A) {
        int mod = 1000000007;
        Arrays.sort(A);
        int max = A[A.length - 1];
        int[] bool = new int[max + 1];
        for (int i = 1; i <= max; i++) {
            bool[i] = 0;
        }

        for (int i = 2; i * i <= max; i++) {
            if (bool[i] == 0) {
                for (int j = i * i; j <= max; j = j + i) {
                    bool[j] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(A));
        //j = 2  | k < 3
        int res = 0;
        List<Integer> prime = new ArrayList<>();
        for (int i = 2; i < bool.length; i++) {
            if (bool[i] == 0) {
                prime.add(i);
            }
        }
        System.out.println(prime.toString());

        //3, 4, 5, 7, 10
        int j = 0;
        while (A[j] < 2) {
            j++;
        }
        for (int i = 0; i < prime.size() - 1; i++) {
            int first = prime.get(i);
            int second = prime.get(i + 1);
            System.out.println("first " + first);
            System.out.println("second " + second);
            int diff = second - first;
            if (diff == 0) {
                res += (Math.pow(2, diff)) - 1;
            } else {
                int countPrime = 0;
                while (j < A.length) {
                    if (A[j] >= first && A[j] < second) {
                        countPrime++;
                    } else {
                        break;
                    }
                    j++;
                }
                System.out.println(countPrime);
                res += (Math.pow(2, countPrime)) - 1;
            }
        }
        res += (Math.pow(2, A.length - j)) - 1;
        return (res % mod);
    }
}
