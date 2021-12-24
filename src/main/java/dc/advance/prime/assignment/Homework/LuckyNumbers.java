package dc.advance.prime.assignment.Homework;

import java.util.Arrays;

public class LuckyNumbers {

    public static void main(String[] args) {
        System.out.println(getSolve(8));
    }

    public static int getSolve(int A) {

        int[] isPrime = new int[A + 1];
        isPrime[0] = -1;
        isPrime[1] = -1;
        for (int i = 2; i <= A; i++) {
            isPrime[i] = 1;
        }

        for (int i = 2; (i * i) <= A; i++) {
            if (isPrime[i] == 1) {
                for (int j = i * i; j <= A; j += i) {
                    isPrime[j] = 0;
                }
            }
        }

        System.out.println("isPrime " + Arrays.toString(isPrime));
        int[] freq = new int[A + 1];
        for (int i = 2; i <= A; i++) {
            for (int j = i; j <= A; j += i) {
                if (isPrime[i] == 1 && j % i == 0)
                    freq[j]++;
            }
        }
        System.out.println("freq " + Arrays.toString(freq));
        int res = 0;
        for (int j : freq) {
            if (j == 2) {
                res++;
            }
        }
        return res;
    }
}

