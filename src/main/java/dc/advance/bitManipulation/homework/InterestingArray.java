package dc.advance.bitManipulation.homework;

public class InterestingArray {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{9, 17}));
    }

    public static String getSolve(int[] A) {
        int oddEvenCount = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] % 2 != 0) {
                oddEvenCount++;
            }
        }
        if (oddEvenCount % 2 != 0) {
            return "No";
        } else {
            return "Yes";
        }
    }
}
