package dc.Contest_1;

public class IntroBlocks {

    public static void main(String[] args) {
        //System.out.println(getSolve(new int[]{3, 1, 3, 2, 1, 2}));
        System.out.println(getSolve(new int[]{3, 7, 3, 7, 3}));
    }


    private static int getSolve(int[] A) {
        int res = 0;
        boolean changeFlag = false;
        int changeValue = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (changeFlag) {
                A[i] = changeValue;
                res++;
                continue;
            }
            if (i == 0) {
                int diff = A[i] - A[i + 1];
                if (diff != 0) {
                    A[i + 1] = A[i];
                    res++;
                }
            } else {
                int diff1 = A[i - 1] - A[i];
                int diff2 = A[i] - A[i + 1];
                if (diff1 != diff2) {
                     A[i + 1] = A[i];
                    changeValue = A[i + 1];
                    res++;
                    changeFlag = true;
                }
            }
        }
        return res;
    }
}
