package dc.advance.bitManipulation.reversion.assignment1.homework;

public class InterestingArray {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{9, 3}));
    }

    public static String solve(int[] A) {
        int oddCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 != 0) {
                oddCount++;
            }
        }

        if (oddCount % 2 != 0) {
            return "No";
        } else {
            return "Yes";
        }
    }

}
