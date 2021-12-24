package dc.advance.bitManipulation.reversion.assignment1;

public class NumSetBits {

    public static void main(String[] args) {
        System.out.println(numSetBits(11));
        System.out.println(numSetBits(3));
    }

    public static int numSetBits(int A) {
        int res = 0;
        while (A != 0) {
            res++;
            A &= A - 1;
        }
        return res;
    }
}


