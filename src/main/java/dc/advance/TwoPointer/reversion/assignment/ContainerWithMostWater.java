package dc.advance.TwoPointer.reversion.assignment;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 5, 4, 3}));
        System.out.println(maxArea(new int[]{1}));
        System.out.println(maxArea(new int[]{1, 5, 4, 3}));
        System.out.println(maxArea(new int[]{3, 8, 7, 4, 6, 4, 2}));
    }

    public static int maxArea(int[] A) {
        if (A.length == 1) {
            return 0;
        }
        int i = 0;
        int j = A.length - 1;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            int width = (j - i);
            max = Math.max(max, Math.min(A[i], A[j]) * width);
            if (A[j] < A[i]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }
}
