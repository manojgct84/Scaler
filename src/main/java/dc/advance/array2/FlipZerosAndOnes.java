package dc.advance.array2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipZerosAndOnes {

    public static void main(String[] args) {
        // System.out.println(Arrays.toString(flip("100100111101")));
        System.out.println(Arrays.toString(solve("010")));
        System.out.println(Arrays.toString(solve("00110")));
        System.out.println(Arrays.toString(solve("010110")));
        System.out.println(Arrays.toString(getSolveAllPossibleIndex("0011101")));
    }

    public static int[] solve(String A) {
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < A.length(); i++) {
            temp.add(Integer.valueOf(A.substring(i, i + 1)));
        }
        int flips = 0;
        int[] res = new int[2];
        int totalFlips = 0;
        int start = 0;
        for (int i = 0; i < temp.size(); ++i) {
            if (temp.get(i) == 0)
                flips++;
            else
                flips--;

            if (flips > totalFlips) {
                res[0] = start + 1;
                res[1] = (i + 1);
                totalFlips = flips;
            }

            if (flips < 0) {
                flips = 0;
                start = i + 1;
            }
        }
        return (res[0] == 0) ? new int[]{} : res;
    }


    public static int[] getSolveAllPossibleIndex(String A) {
        List<Integer> temp = new ArrayList<>();

        for (int i = 0; i < A.length(); i++) {
            temp.add(Integer.valueOf(A.substring(i, i + 1)));
        }
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) == 1) {
                temp.set(i, -1);
            } else {
                temp.set(i, 1);
            }
        }

        int[] pf = new int[temp.size()];

        pf[0] = temp.get(0) == -1 ? 0 : temp.get(0);

        for (int i = 1; i < temp.size(); i++) {
            int val = temp.get(i) + pf[i - 1];
            pf[i] = Math.max(val, 0);
        }
        int flips = 0;
        int[] res = new int[2];
        int totalFlips = 0;
        int start = 0;
        //System.out.println(Arrays.toString(pf));
        for (int i = 0; i < pf.length; i++) {
            if (pf[i] == 0) {
                flips--;
            } else {
                flips++;
            }

            if (flips > totalFlips) {
                res[0] = start + 1;
                res[1] = (i + 1);
                totalFlips = flips;
            }

            if (flips < 0) {
                flips = 0;
                start = i + 1;
            }
        }
        return (res[0] == 0) ? new int[]{} : res;
    }
}
