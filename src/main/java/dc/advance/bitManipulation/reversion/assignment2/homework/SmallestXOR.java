package dc.advance.bitManipulation.reversion.assignment2.homework;

public class SmallestXOR {

    public static void main(String[] args) {
        System.out.println(solve(3, 3));
        System.out.println(solve(15, 2));
        System.out.println(solve(10, 2));
    }

    public static int solve(int A, int B) {
        int[] x = new int[32];
        int X = 31;
        int count = 0;
        //Integer to Binary
        while (A > 0 && X >= 0) {
            if (A % 2 == 0) {
                x[X] = 0;
            } else {
                x[X] = 1;
                count++;
            }
            A /= 2;
            X--;
        }
       // System.out.println(Arrays.toString(x));
       // System.out.println(count);
        int i = x.length - 1;
        //if the set bit is less than B then check if there is unset bit
        if (count < B) {
            while (i >= 0) {
                if (x[i] == 0) {
                    x[i] = 1;
                    count++;
                    if (count == B) {
                        break;
                    }
                }
                i--;
            }
            //if the set bit is greater than B then check if there is set bit to unset bit.
        } else if (count > B) {
            while (i >= 0) {
                if (x[i] == 1) {
                    x[i] = 0;
                    count--;
                    if (count == B) {
                        break;
                    }
                }
                i--;
            }
        }

        int j = x.length - 1;
        int res = 0;
        int k = 0;
        // Binary to Integer [2^0 -> 2^1 -> 2^2]
        while (j >= 0) {
            res += x[j] * Math.pow(2, k);
            j--;
            k++;
        }

        return res;
    }
}
