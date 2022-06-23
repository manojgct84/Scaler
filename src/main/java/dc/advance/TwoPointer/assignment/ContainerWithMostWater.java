package dc.advance.TwoPointer.assignment;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(getMaxArea(new int[]{1, 5, 4, 3}));
        System.out.println(getMaxArea(new int[]{3, 8, 7, 4, 6, 4, 2}));
    }

    public static int getMaxArea(int[] A) {

        int left = 0;
        int right = A.length - 1;

        int min;
        int max = Integer.MIN_VALUE;
        while (left < right) {
            min =Math.min(A[left], A[right]) *  (right - left);
            max = Math.max(min, max);
            int i = A[left] < A[right] ? left++ : right--;
        }
        return max;
    }
}
