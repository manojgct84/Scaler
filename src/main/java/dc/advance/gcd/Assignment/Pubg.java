package dc.advance.gcd.Assignment;

public class Pubg {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{6, 4}));
    }

    public static int getSolve(int[] A) {
        if (A.length == 1) {
            return A[0];
        }
        int res = Integer.MAX_VALUE;
        int val = 0;
        for (int i = 0; i < A.length ; i++) {
            val = gcd(A[i], val);
            if (val != 0) {
                System.out.println(val);
                res = Math.min(res, val);
            }
        }
        return res;
    }

    private static int gcd(int A, int B) {

        while (B > 0) {
            int temp = B;
            B = A % B;
            A = temp;
        }
        System.out.println("A " + A);
        return A;
    }
}
