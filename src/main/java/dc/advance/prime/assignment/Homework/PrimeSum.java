package dc.advance.prime.assignment.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolve(10)));
    }

    public static int[] getSolve(int A) {
        int[] isPrime = new int[A + 1];
        isPrime[0] = -1;
        isPrime[1] = -1;
        for (int i = 2; i <= A; i++) {
            isPrime[i] = 0;
        }

        for (int i = 2; i * i <= A; i++) {
            if (isPrime[i] == 0) {
                for (int j = i * i; j <= A; j = j + i) {
                    isPrime[j] = 1;
                }
            }
        }
        System.out.println(Arrays.toString(isPrime));
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <=(A - i); i++) {
            if (isPrime[i] == 0 && isPrime[A - i] == 0) {
                res.add(i);
                res.add(A - i);
                break;
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
