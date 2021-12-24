package dc.clazz.problem.solving1;

public class PickBothSide {


    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{-969, -948, 350, 150, -59, 724, 966, 430, 107, -809, -993, 337, 457, -713, 753, -617, -55, -91, -791, 758, -779, -412, -578, -54, 506, 30, -587, 168, -100, -409, -238, 655, 410, -641, 624, -463, 548, -517, 595, -959, 602, -650, -709, -164, 374, 20, -404, -979, 348, 199, 668, -516, -719, -266, -947, 999, -582, 938, -100, 788, -873, -533, 728, -107, -352, -517, 807, -579, -690, -383, -187, 514, -691, 616, -65, 451, -400, 249, -481, 556, -202, -697, -776, 8, 844, -391, -11, -298, 195, -515, 93, -657, -477, 587}, 81));
    }

    private static int getSolve(int[] A, int B) {
        int leftSum = 0;
        int rightSum = 0;
        int max = 0;
        int min;
        for (int i = 0; i < B; i++) {
            leftSum += A[i];
        }
        max = leftSum + rightSum;
        min = leftSum + rightSum;
        int i = B - 1;
        int j = A.length - 1;
        while (i >= 0) {
            leftSum = leftSum - (A[i]);
            System.out.println(leftSum);
            rightSum = rightSum + (A[j]);
            //System.out.println(rightSum);
            max = Math.max(max, leftSum + rightSum);
            min = Math.min(min, leftSum + rightSum);
            i--;
            j--;
        }
        return max != 0 ? max : min;
    }
}
