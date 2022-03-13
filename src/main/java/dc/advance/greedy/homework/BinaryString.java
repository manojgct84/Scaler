package dc.advance.greedy.homework;

import java.util.Arrays;

public class BinaryString {

    public static void main(String[] args) {
        System.out.println(binaryString("00010110", 3));
        System.out.println(binaryString("011", 3));
    }

    public static int binaryString(String A, int B) {
        int xor = 0;
        int res = 0;
        int[] bits = new int[A.length()];
        int[] temp = new int[bits.length];
        Arrays.fill(temp, 0);
        for (int j = 0; j < A.length(); j++) {
            bits[j] = A.charAt(j) - '0';
        }

        int k = 0;
        for (int i = 0; i < bits.length - B; i++) {
            xor ^= temp[i];
            if ((bits[i] == 0 && xor == 0) || (bits[i] == 1 && xor == 1)) {
                res++;
                if ((i + B) < bits.length) {
                    temp[i + B] = 1;
                }
                xor = 1 - xor; // toggle 1 or 0.
            }
            k++;
        }

        while (k < bits.length) {
            xor ^= temp[k];
            int val = bits[k];
            if ((val ^ xor) == 0) {
                return -1;
            }
            k++;
        }
        return res;
    }
}
