package dc.numberTheory;

public class NumberTheory {


    public static void main(String[] args) {
        int a = 4;
        int b = 5;
        int c = 5;
        int prod = 1;
        for (int i = 0; i < b; i++) {
            prod = (prod * a);
        }
        System.out.println(prod % c);
        System.out.println(gcd(8632, 8650));
        findMidElement();

    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static int factor(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factor(n - 1);
    }

    private static int fab(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        //0,1,1,2,3
        //
        return factor(n - 1) + factor(n - 2);
    }


    private static int knapsnack(int[] val, int[] wt, int W, int N) {

        if (N == 0) {
            return 0;
        }
        if (W == 0) {
            return 0;
        }

        if (wt[N] <= W) {
            int x = val[N] + knapsnack(val, wt, W - wt[N], N - 1);
            int y = knapsnack(val, wt, W, N - 1);
            return Math.max(x, y);
        }
        return knapsnack(val, wt, W, N - 1);
    }


    private static void findMidElement() {
        int low = 0;
        int high = 15;
        if (high % 2 == 0) {
            System.out.println(low + (high - low) / 2);
        } else {
            System.out.println((low + (high - low)) / 2);
        }
    }


}
