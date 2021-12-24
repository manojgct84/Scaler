package dc.advance.TwoPointer.assignment;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(getMaxArea(new int[]{1, 5, 4, 3}));
        System.out.println(getMaxArea(new int[]{3, 8, 7, 4, 6, 4, 2}));
    }

    public static int getMaxArea(int[] A) {

        int i = 0;
        int j = A.length - 1;

        int min;
        int max = Integer.MIN_VALUE;
        while (i < j) {
            min = (j - i) * Math.min(A[j], A[i]);
            max = Math.max(min, max);
            if (A[i] < A[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
