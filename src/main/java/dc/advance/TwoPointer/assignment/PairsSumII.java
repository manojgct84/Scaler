package dc.advance.TwoPointer.assignment;

public class PairsSumII {

    public static void main(String[] args) {
/*        System.out.println(getSolve(new int[]{1, 1, 1}, 2));
        System.out.println(getSolve(new int[]{1, 1}, 2));
        System.out.println(getSolve(new int[]{2, 3, 5, 6, 10}, 6));*/
        // System.out.println(getSolve(new int[]{1, 2, 6, 6, 7, 9, 9}, 13));
        //System.out.println(getSolve(new int[]{2, 3, 3, 5, 7, 7, 8, 9, 9, 10, 10}, 11));
        //System.out.println(getSolve(new int[]{1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 9, 10}, 5));
        //System.out.println(getSolve(new int[]{2, 2, 3, 4, 4, 5, 6, 7, 10}, 8));
       // System.out.println(getSolve(new int[]{1, 2, 6, 6, 7, 9, 9}, 13));
        System.out.println(getSolve(new int[]{2, 2, 3, 4, 4, 5, 6, 7, 10}, 8));
    }

    static int mod = 1000000007;

    public static int getSolve(int[] A, int B) {
        int i = 0;
        int j = A.length - 1;
        int sum = 0;
        long res = 0;
        while (i < j) {
            sum = (A[i] + A[j]);
            if (sum < B) {
                i++;
            } else if (sum > B) {
                j--;
            } else if (A[i] == A[j]) {
                int v = j - i + 1;
                res = res + v * (v - 1) / 2;
                break;
            } else if (A[i] != A[j]) {
                int x = A[i], y = A[j];
                int ci = 0;
                int cj = 0;
                while (i < A.length && A[i] == x) { // if there is left duplicate value
                    i++;
                    ci++;
                }
                while (j < A.length && A[j] == y) { // if there is left duplicate value
                    j--;
                    cj++;
                }
                res = (res % mod) + ((cj * ci) % mod) % mod;
            }
        }
        return (int) (res % mod);
    }

    /*{
        int x = A[i];
        int xx = i;
        while ((i < j) && (A[i] == x)) {
            i++;
        }
        int y = A[j], yy = j;
        while ((j >= i) && (A[j] == y)) {
            j--;
        }
        if (x == y) {
            int temp = i - xx + yy - j - 1;
            res += (temp * (temp + 1)) / 2;
        } else {
            res += (i - xx) * (yy - j);
        }
    }*/
}