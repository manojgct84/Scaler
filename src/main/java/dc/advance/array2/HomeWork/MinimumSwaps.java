package dc.advance.array2.HomeWork;

public class MinimumSwaps {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 12, 10, 3, 14, 10, 5}, 8));
    }


    //Sliding window tech
    public static int getSolve(int[] A, int B) {

        int count = 0;
        for (int k : A) {
            if (k <= B) {
                count++;
            }
        }

        int swap = 0;
        int res = 0;
        //First sliding window.
        for (int i = 0; i < count; i++) {
            if (A[i] > B) {
                swap++;
            }
        }
        res = swap;
        int j = count;

        while (j < A.length) {
            int removeFirstIndex = j - count;
            if (A[j] > B) {
                swap++;
            }
            //remove the last element from the array
            if (A[removeFirstIndex] > B) {
                swap--;
            }
            res = Math.min(res, swap);

            j++;
        }

        return res;


    }
}
