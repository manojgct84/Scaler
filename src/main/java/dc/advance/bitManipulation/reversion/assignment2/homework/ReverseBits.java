package dc.advance.bitManipulation.reversion.assignment2.homework;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverse(0));
        System.out.println(reverse(3));
    }

    public static long reverse(long a) {
        long[] bits = new long[32];
        long k = 0;
        while (a > 0) {
            if (a % 2 == 0) {
                bits[(int) k++] = 0;
            } else {
                bits[(int) k++] = 1;
            }
            a /= 2;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            str.append(bits[i]);
        }

        return Long.parseLong(str.toString(), 2);
    }
}
