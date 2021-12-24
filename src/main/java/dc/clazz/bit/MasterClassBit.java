package dc.clazz.bit;

public class MasterClassBit {

    public static void main(String[] args) {
        twodifferentNumber(new int[]{4, 1, 2, 3, 2, 1, 5, 4});
        //checkIfBitIsSet(6);
        //binarySearch(new int[]{1, 2, 3, 4, 5, 6}, 6);
        //fastLoop(10);
        //logicalRightShiftAndArthmeticRightShift();
        unSetiThBit();
    }

    private static void twodifferentNumber(int[] ints) {
        int xor = 0;

        for (int anInt : ints) {
            xor ^= anInt;
        }
        // position at which the bit is set '1'
        int pos = 0;
        for (int i = 0; i < 31; i++) {
            if ((xor & (1 << i)) > 0) {
                pos = i;
                break;
            }
        }
        int first = 0, second = 0;
        for (int anInt : ints) {
            if (((anInt >> pos) & 1) == 1) {
                first ^= anInt;
            } else
                second ^= anInt;
        }

        System.out.println(first + " " + second);
    }

    private static void checkIfBitIsSet(int A) {
        System.out.println(Integer.toBinaryString(A));
        for (int i = 0; i < 31; i++) {
            if ((A & (1 << i)) > 0) {
                System.out.println("position at which the bit is set :: " + i);
            }
        }
    }

    public static void binarySearch(int[] A, int k) {
        int l = 0;
        int h = A.length;
        while (l < h) {
            int mid = (l + h) >> 1;
            if (A[mid] < k) {
                System.out.println(mid);
                h = mid - 1;
            } else if (A[mid] > k) {
                System.out.println(mid);
                l = mid + 1;
            }
        }
    }

    public static void fastLoop(int n) {
        /*for (int i = n; i > -1; i /= 2) {
            System.out.println(i);

        }*/

        for (int i = 1; i < n; i *= 2) {
            System.out.println(i);

        }
    }


    public static void logicalRightShiftAndArthmeticRightShift() {
        int a = -5;
        int b = -5;

        System.out.println("a " + Integer.toBinaryString(a));
        System.out.println("b " + Integer.toBinaryString(b));

        a = a >>> 1;
        b = b >> 1;

        System.out.println("after shift a " + Integer.toBinaryString(a) + " :" + a);
        System.out.println("after shift b " + Integer.toBinaryString(b) + " :" + b);
    }


    public static void unSetiThBit() {
        int a = 4;
        int b = 4;
        System.out.println("binary a " + Integer.toBinaryString(a));
        //Set the ith bit.
        a |= (1 << 1);

        System.out.println("set ith a " + Integer.toBinaryString(a));
        //UnSet the ith bit.
        a &= ~(1 << 1);

        System.out.println("unset ith a " + Integer.toBinaryString(a));

        //toggle a ith bit
        int pos = 1;
        b ^= (1 << pos);
        System.out.println("flip ith b " + Integer.toBinaryString(b));
        int i = 2;
        if ((b & (1 << (i))) > 0) {

            System.out.println("left Bit is set");
        }

        if (((i >> 1) & 1) > 0) {

            System.out.println("right Bit is set");
        }
    }
}
