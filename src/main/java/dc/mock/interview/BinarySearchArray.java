package dc.mock.interview;

public class BinarySearchArray {

/*    arr = [0, 0, 1, 1, 1]
            0s and 1s, any number on right of a 1 will be always 1.
            return the position of 1st occurence of 1.

    int res = 2
 */

    public static void main(String[] args) {
        System.out.println((getIndex(new int[]{0, 0, 0, 0, 1, 1, 1})));
        System.out.println("Output :" + (getIndex(new int[]{0, 0, 0, 0, 1})));
        System.out.println("Output :" + (getIndex(new int[]{0, 0, 0, 0, 0})));
        System.out.println("Output :" + (getIndex(new int[]{0, 0, 1, 1, 1})));
        System.out.println("Output :" + (getIndex(new int[]{0, 1, 1})));
    }

    public static int getIndex(int[] A) { // [0, 0, 0, 0, 1, 1, 1]
        if (A == null || A.length == 0) { // f
            return -1;
        }
        if (A.length == 1) { // f
            return A[0] == 1 ? 0 : -1;
        }

        int low = 0;
        int high = A.length;// 7
        int mid;
        while (low < high) {  //2 -> // 3 + (7 - 3)/2 = 2 + 3 = 5
            mid = low + ((high - low) >> 2); // 3 -> 3 +(5 -3)/2 = 1 + 2 = 4
            //System.out.println("low: " + low); // 4
            //System.out.println("mid: " + mid); // 4
            //System.out.println("high:" + high); // 4
            if (mid >= 0 && A[mid] == 1 && (mid == 0 || A[mid - 1] == 0)) { //T
                return mid;
            }
            if (mid == A.length - 1) {
                return -1;
            }
            if (mid >= 0 && A[mid] == 0) { // t
                low = mid;  // low = 3
            } else {
                high = mid; // high = 5
            }
        }
        return -1;
    }


    public static int firstOccur(int[] A) { // [0, 0, 0, 0, 1, 1, 1]
        if (A == null || A.length == 0) { // f
            return -1;
        }
        if (A.length == 1) { // f
            return A[0] == 1 ? 0 : -1;
        }

        int low = 0;
        int high = A.length;// 7
        int mid;
        while (low < high) {  //2 -> // 3 + (7 - 3)/2 = 2 + 3 = 5
            mid = low + ((high - low) >> 1); // 3 -> 3 +(5 -3)/2 = 1 + 2 = 4
            //System.out.println("low: " + low); // 4
            //System.out.println("mid: " + mid); // 4
            //System.out.println("high:" + high); // 4
            if (mid >= 0 && A[mid] == 1 && (mid == 0 || A[mid - 1] == 0)) { //T
                return mid;
            }
            if (mid == A.length - 1) {
                return -1;
            }
            if (mid >= 0 && A[mid] == 0) { // t
                low = mid;  // low = 3
            } else {
                high = mid; // high = 5
            }
        }
        return -1;
    }
}
