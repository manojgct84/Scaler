package dc.advance.combinatorics.Homework;

public class SortedPermutationRankRepeats {

    public static void main(String[] args) {
        System.out.println(findRank("QueUE"));
    }

    static int mod = 1000003;

    public static int findRank(String A) {

        if (A == null || A.length() == 0) {
            return 0;
        }

        int res = 1;
        for (int i = 0; i < A.length(); i++) {
            int count = 0;
            for (int j = i + 1; j < A.length(); j++) {
                if (A.charAt(i) > A.charAt(j)) {
                    count++;
                }
            }
            int[] freq = new int[52];
            for (int j = i; j < A.length(); j++) {
                if (A.charAt(j) >= 'a' && A.charAt(j) <= 'z') {
                    freq[A.charAt(j) - 'a']++;
                } else {
                    freq[A.charAt(j) - 'A' + 26]++;
                }
            }
            long f = 1;

            for (int j : freq) {
                if (j !=0) {
                    f = f * fact(j) % mod;
                }
            }
            long inverse = getFermatSolve(f, mod);
            res = (int) ((res % mod) + (count * fact(A.length() - 1 - i) * inverse) % mod);
        }
        return res;
    }

    public static int getFermatSolve(long A, int B) {
        int result = 1;
        long p = B - 2;
        long a = A;
        while (p > 0) {
            if (p % 2 == 1) {
                result = (int) ((result * a) % mod);
            }
            a = (a * a) % mod;
            p >>= 1;
        }
        return result;
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
