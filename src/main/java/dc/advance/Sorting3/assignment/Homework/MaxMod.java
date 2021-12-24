package dc.advance.Sorting3.assignment.Homework;

public class MaxMod {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 2, 44, 3}));
        System.out.println(getSolve(new int[]{5, 5, 5, 5}));
        System.out.println(getSolve(new int[]{1, 2, 3, 3}));
    }

    public static int getSolve(int[] A) {

        int first = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            if (first < A[i]) {
                sec = first;
                first = A[i];
               // System.out.println(sec);
            } else if (sec < A[i] && sec != first && first != A[i]) {
                sec = A[i];
            }
        }
        if (sec == Integer.MIN_VALUE) {
            return 0;
        }
        return sec;
    }
}
