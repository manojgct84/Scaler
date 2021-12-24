package dc.clazz.array.day2;

public class ClosestMinMax {

    public static void main(String[] args) {
        //System.out.println(getSolve(new int[]{377, 448, 173, 307, 108}));
        //System.out.println(getSolve(new int[]{613, 116, 420, 672, 426}));
        System.out.println(getSolve(new int[]{834, 563, 606, 221, 165}));

    }

    private static int getSolve(int[] A) {
        if (A.length == 1) {
            return 1;
        }

        if (A.length == 2) {
            return 2;
        }

        int min_value = Integer.MAX_VALUE;
        int max_value = Integer.MIN_VALUE;
        for (int j : A) {
            min_value = Math.min(min_value, j);
            max_value = Math.max(max_value, j);
        }
        System.out.println(min_value + " " + max_value);
        int last_min_index = -1;
        int last_max_index = -1;
        int res = Integer.MAX_VALUE;
        //handle duplicates values - min =4 and max =4
        if (min_value == max_value) {
            return 1;
        }
        for (int i = 0; i < A.length; i++) {
            if (min_value == A[i]) {
                if (last_max_index >= 0) {
                    res = Math.min(res, (i - last_max_index) + 1);
                }
                last_min_index = i;
            } else if (max_value == A[i]) {
                if (last_min_index >= 0) {
                    res = Math.min(res, (i - last_min_index) + 1);
                }
                last_max_index = i;
            }
        }
        return res;
    }
}
