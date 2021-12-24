package dc.advance.Sorting3.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SumTheDifference {

    public static void main(String[] args) {
        System.out.println(getSolve(new ArrayList<>(Arrays.asList(1, 2))));
    }

    public static int getSolve(ArrayList<Integer> A) {
        Collections.sort(A);
        int res;
        long max = 0;
        long min = 0;
        int pow = 2;
        long mod = 1000000007;

        for (int i = 0; i < A.size(); i++) {
            min = (pow * min + A.get(i)) % mod;
            max = (pow * max + A.get(A.size() - i - 1));
        }

        res = (int) (((max % mod) - (min % mod) + mod) % mod);
        return res;
    }

    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int Mod = 1000 * 1000 * 1000 + 7;
        long minus = 0, plus = 0;
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            minus += (val * pow(2, A.size() - 1 - i, Mod)) % Mod;
            minus %= Mod;
            plus += (val * pow(2, i, Mod)) % Mod;
            plus %= Mod;
        }
        return (int) ((plus - minus + Mod) % Mod);
    }

    public long pow(long base, int y, int k) {
        long result = 1;
        while (y > 0) {
            if (y % 2 == 1) {
                result = (result * base) % k;
                y--;
            }
            y >>= 1;
            base = (base * base) % k;
        }
        return result;
    }
}
