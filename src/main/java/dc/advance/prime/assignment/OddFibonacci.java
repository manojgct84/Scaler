package dc.advance.prime.assignment;

import java.util.Arrays;

public class OddFibonacci {

    public static void main(String[] args) {
        System.out.println(getBetterSolve(17224, 100000884));
    }

    //this does not work for large inputs
    public static int getSolve(int A, int B) {
        int[] fib = new int[B + 1];

        fib[0] = 0;
        fib[1] = 1;
        //1 , 2, 3, 5, 8, 13
        for (int i = 2; i <= B; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        System.out.println(Arrays.toString(fib));
        int oddNumber = 0;
        if (A == 2) {
            oddNumber++;
        }

        for (int i = A; i <= B; i++) {
            if ((fib[i] & 1) > 0) {
                oddNumber++;
            }
        }
        return oddNumber;
    }

    public static int getBetterSolve(int A, int B) {
        int evenNumber = Math.floorDiv(B, 3) - Math.floorDiv(A - 1, 3);
        return (B - A + 1) - evenNumber;

    }
}
