package dc.advance.TwoPointer.reversion.homework;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same
 * color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 *
 * Note: Using library sort function is not allowed.
 */
public class SortByColor {

    public static void main(String[] args) {
        System.out.println(sortColors(new ArrayList<>(Arrays.asList(0, 1, 2, 0, 1, 2))));
        System.out.println(sortColors(new ArrayList<>(Arrays.asList(0))));
    }


    public static ArrayList<Integer> sortColors(ArrayList<Integer> A) {
        int[] freq = new int[3];
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == 0) {
                freq[0]++;
            } else if (A.get(i) == 1) {
                freq[1]++;
            } else if (A.get(i) == 2) {
                freq[2]++;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            int k = 0;
            while (k < freq[i]) {
                res.add(i);
                k++;
            }
        }
        return res;
    }
}
