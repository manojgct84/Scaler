package dc.advance.bitManipulation.reversion.assignment2;

public class CountTotalSetBits {

    public static void main(String[] args) {
        System.out.println(solve(3));
    }

    public static int solve(int A) {

        //One way
        /*for (int i = 0; i < 32; i++) {
            if (((A >> i) & 1) == 1) {
                count++;
            }
        }
        //Other way
        while (A != 0) {
            count++;
            A &= (A - 1);
        }*/

        int a = A + 1;
        int mod = 1000000007;
        long pow = 1;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count = (int) ((count % mod) + ((a / (pow << 1)) * pow) % mod + Math.max(0, a % (pow << 1) - pow) % mod);
            pow = pow << 1;
        }
        return count;
    }
}
