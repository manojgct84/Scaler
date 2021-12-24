package dc.advance.array1;

public class MaximumAbsoluteDifference {

    public static void main(String[] args) {
        System.out.println(maxArr(new int[]{-39, -24, 82, 95, 91, -65, 16, -76, -56, 70}));
    }


    public static int maxArr(int[] A) {

        int x1 = Integer.MIN_VALUE;
        int x2 = Integer.MAX_VALUE;
        int y1 = Integer.MIN_VALUE;
        int y2 = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            x1 = Math.max(x1, A[i] + i);
            y1 = Math.max(y1, A[i] - i);

            x2 = Math.min(x2, A[i] + i);
            y2 = Math.min(y2, A[i] - i);
        }
        System.out.println("X1 " + x1 + " X2 " + x2 + " y1 " + y1 + " y2 " + y2);
        return Math.max(x1 - x2, y1 - y2);
    }
}
