package dc.ProblemSolving2;

public class SubarrayLeastAverage {


    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{3, 7, 90, 20, 10, 50, 40}, 3));
    }


    private static int getSolve(int[] A, int B) {
        int sum = 0;
        for (int i = 0; i < B; i++) {
            sum += A[i];
        }
        System.out.println("sum:" + sum);
        int min = sum;
        int index = 0;
        int prev = Integer.MAX_VALUE;
        //min = 11
        //pre = 99999;
        //index =1;

        for (int i = B; i < A.length; i++) {
            sum += A[i];
            sum -= A[i - B];
            prev = min;
            min = Math.min(min, sum);
            if (min < prev) {
                index = i - B + 1;
                prev = min;
            }
            System.out.println("sum: " + sum + " i " + i + " index " + index);
        }
        return index;
    }
}
