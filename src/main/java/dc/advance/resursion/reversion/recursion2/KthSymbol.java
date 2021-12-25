package dc.advance.resursion.reversion.recursion2;

public class KthSymbol {

    public static void main(String[] args) {
        System.out.println(solve(2, 1));
        System.out.println(solve(2, 2));
        System.out.println(solve(5, 5));
        System.out.println(solve(9, 175));
    }

    public static int solve(int N, int K) {
        if (N == 0 || K == 0) {
            return 0;
        }
        /* int x = solve(N - 1, K / 2);

        if ((K & 1) == 0) {
            return x ;
        } else {
            return 1 - x;
        }
       */
        int x;
        if ((K & 1) == 0) {
            x = solve(N - 1, K / 2) == 0 ? 1 : 0;
        } else {
            x = solve(N - 1, (K + 1) / 2);
        }
        return x;
    }
}
