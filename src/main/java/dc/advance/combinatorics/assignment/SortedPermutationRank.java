package dc.advance.combinatorics.assignment;

public class SortedPermutationRank {

    public static void main(String[] args) {
        System.out.print(getSolve("aba"));
    }

    public static int getSolve(String A) {
        int mod = 1000003;
        if (A == null || A.length() == 0) {
            return 0;
        }
        int res = 1;
        for (int i = 0; i < A.length(); i++) {
            int count = 0;
            for (int j = i + 1; j < A.length(); j++) {
                if (A.charAt(j) < A.charAt(i)) {
                    count++;
                }
            }
            res = (res % mod) + (count * fact(A.length() - 1 - i)) % mod;
        }
        return res;
    }

    private static int fact(int n) {
        int mod = 1000003;
        if (n > -1 && n < 2) {
            return 1;
        }
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = (fact * i) % mod;
        }
        return (fact % mod);
    }
}
