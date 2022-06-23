package dc.advance.array1.Homework;

public class MinimumNumberOfJumps {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{1, 2, 3, 4, 5}));
    }

    public static int finadMinJump(int[] A) {
        int maxJump = A[0];
        int stepsToMove = A[0];
        int jump = 1;
        if (maxJump == 0) {
            return -1;
        }
        for (int i = 1; i < A.length; i++) {

            if (i == A.length - 1) {
                return jump;
            }
            maxJump = Math.max(maxJump, i + A[i]);
            stepsToMove--;
            if (stepsToMove == 0) {
                stepsToMove = maxJump - i;
                jump++;
            }
        }
        return -1;
    }
}
