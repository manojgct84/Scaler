package dc.Problem.Solving3.Assignment;

import java.util.Arrays;

public class SortUnsortedArray {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{-355071087, -679308132, 398052175, 755454983, 814022370, 889267058}));
    }

    private static int getSolve(int[] A) {

        int indexL = -1;
        int indexR = -1;
        int[] copy;
        copy = Arrays.copyOf(A, A.length);
        Arrays.sort(copy);
        System.out.println(Arrays.toString(copy));
        //0,1,6,7,15,25,30,40,50
        int i = 0;
        while (i < A.length) { //0, 1, 15, 25, 6, 7, 30, 40, 50  //0, 1, 6, 7, 15, 25, 30, 40, 50
            if (A[i] == copy[i]) { //30 == 30
                i++;
                continue;
            } else if (indexL < 0) {
                indexL = i; // 2
                System.out.println("indexL " + indexL);
            } else {
                indexR = i; // 6
                System.out.println("indexR " + indexR);
            }
            i++;
        }
        return indexR != -1 && indexL != -1 ? ((indexR + 1) - indexL) : 0; // 4
    }
}
