package dc.advance.array1;

public class ClosestMinMax {

    public static void main(String[] args) {
        System.out.println(findMinMax(new int[]{343, 291, 963, 165, 152}));
    }

    public static int findMinMax(int[] A) {
        if (A.length == 1) {
            return 1;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int j : A) {
            max = Math.max(max, j);
            min = Math.min(min, j);
        }

        int max_index = -1;
        int min_index = -1;

        int res = Integer.MAX_VALUE;
        // System.out.println("max " + max + " min " + min);
        for (int i = 0; i < A.length; i++) {
            if (A[i] == max) {
                max_index = i;
            }
            if (A[i] == min) {
                min_index = i;
            }
            // System.out.println("max_index " + max_index + " min_index " + min_index);
            if (max_index != -1 && min_index != -1) {
                int val = Math.max(max_index, min_index) - Math.min(max_index, min_index) +1;
                res = Math.min(res, val);
            }
            // System.out.println("res " + res);
        }
        return res;
    }
}
