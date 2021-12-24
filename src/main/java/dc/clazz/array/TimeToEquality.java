package dc.clazz.array;

import java.util.Arrays;

public class TimeToEquality {

    public static void main(String[] args) {
        System.out.println(getTimeToEquality(new int[]{2, 4, 1, 3, 2}));
    }

    private static int getTimeToEquality(int[] A) {
        Arrays.sort(A);
        int last = A[A.length - 1];
        int sum = 0;
        for (int i = 0; i < A.length - 1; i++) {
            sum += last - A[i];
            System.out.println("Sum " + sum + " " + A[i]);
        }
        return sum;
    }
}
