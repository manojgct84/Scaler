package dc.advance.mod.assignment.Homework;

public class ModSum {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 2, 3}));
    }

    public static int getSolve(int[] A) {
        int mod = 1000000007;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            max = Math.max(max, i);
        }

        int[] freq = new int[max + 1];

        for (int k : A) {
            freq[k]++;
        }

        long res = 0;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max; j++) {
                System.out.println("i " + freq[i] + " j " + freq[j] + " i%j " + i % j);
                res += freq[i] * freq[j] * (i % j);
                res = (res % mod);
            }
        }
        return (int) res;
    }
}
