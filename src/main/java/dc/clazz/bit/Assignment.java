package dc.clazz.bit;

public class Assignment {

    public static void main(String[] args) {
        //System.out.println(singleNumber(new int[]{1, 2, 2}));
        //System.out.println(numSetBits(3));
        System.out.println(countNumSetBits(3));
        System.out.println(addBinary("1010110111001101101000", "1000011011000000111100110"));
    }

    public static int singleNumber(final int[] A) {
        int x = 0;
        for (int j : A) {
            x ^= j;
        }
        return x;
    }

    public static int numSetBits(int A) {
        int count = 0;
        while (A > 0) {
            if ((A & 1) == 1) {
                System.out.println("Count: " + Integer.toBinaryString(A));
                count += 1;
            }
            A = A >> 1;
            System.out.println(Integer.toBinaryString(A));
        }
        return count % 1000000007;
    }

    public static int countNumSetBits(int num) {
        int count = 0;
       /* for (int i = 1; i <= num; i++) {
            int A = i;
            System.out.println("A " + A);
            while (A > 0) {
                if ((A & 1) == 1) {
                    System.out.println("Count: " + Integer.toBinaryString(A));
                    count += 1;
                }
                A = A >> 1;
                System.out.println(Integer.toBinaryString(A));
            }
        }*/

        /*for (int i = 1; i <= num; i++) {
            if (i <= 10) {
                for (int j = 0; j < 32; j++) {
                    //1>>0 ==0, 1>>2 1>>3
                    if (((i >> j) & 1) == 1) {
                        count += 1;
                    }
                }
            }
        }*/

        long A = num + 1;
        long pow = 1;
        long mod = 1000000007;
        for (int i = 0; i < 32; i++) {
            /*long k1 = (long) Math.pow(2, i);
            long pow = (i << 1);
            long pow = (long) Math.pow(2, i + 1);*/
            count += (((A / (pow << 1) ) * pow)) % mod + Math.max(0, (A % (pow << 1)) - pow);
            count %= mod;
            pow = pow << 1;
        }
        long C = 0;
        for(int i = 30; i >= 0; i--) {
            if((num & (1 << i)) > 0) {
                // bit is set
                long x = i;
                x = x * (1 << (i - 1));
                C += x + 1; // total set bit count up to 2^i
                num -= 1 << i;
                C += num; // extra bits
            }
        }
       // return (int)(C % 1000000007);
        return count;
    }

    public static String addBinary(String A, String B) {
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        int i = a.length - 1, j = b.length - 1;
        //A = 10110  c = 1
        //B =101010  000000
        //A : " 1010110111001101101000"      C = 0
        //B : "10 0 0011011000000111100110"    A =  1001110001111010101001110
        while (i >= 0 || j >= 0) {
            int i1 = 0;
            int i2 = 0;
            if (i >= 0) {
                i1 = a[i] - '0';
            }
            if (j >= 0) {
                i2 = b[j] - '0';
            }
            i1 = i1 + i2;
            if (i1 + carry == 0) {
                builder.append(0);
            } else {
                if (i1 + carry == 1) {
                    builder.append(1);
                    carry = 0;
                } else if (i1 + carry == 2) {
                    builder.append(0);
                    carry = 1;
                } else if (i1 + carry == 3) {
                    builder.append(1);
                    carry = 1;
                } else {
                    builder.append(0);
                }
            }
            i--;
            j--;
        }
        if (carry != 0) {
            builder.append(carry);
        }
        //1001110001111010101001110
        //1001110001111010101001110

        System.out.println(builder.toString());
        return builder.reverse().toString();
    }
}
