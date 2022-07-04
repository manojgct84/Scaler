package dc.advance.array1.Homework;

public class JumpGame {


    // Find the min jump to reach last of the array

    public static void main(String[] args) {
        System.out.println(jumpGame(new int[]{2, 3, 1, 1, 4}));
    }

    /**    0 + 2 = [2] - inx
     *  2     3    1    1   4 - val
     *  0     1    2    3   4  - inx
     *  l = 0
     *  r = 0
     */
    private static int jumpGame(int[] a) {
        int res = 0;
        int l = 0;
        int r = 0;
        while (r < a.length - 1) {
            int farReach = 0;
            for (int i = l; i < r + 1; i++) {
                farReach = Math.max(farReach, i + a[i]);
            }
            l = r + 1;
            r = farReach;
            res++;
        }
        return res;
    }
}
