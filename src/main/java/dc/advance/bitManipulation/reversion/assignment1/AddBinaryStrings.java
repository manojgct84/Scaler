package dc.advance.bitManipulation.reversion.assignment1;

public class AddBinaryStrings {

    public static void main(String[] args) {
        System.out.println(getAddBinary("110", "11"));
        System.out.println(getAddBinary("1000011", "11"));
        System.out.println(getAddBinary("1010110111001101101000", "1000011011000000111100110"));
        System.out.println(getAddBinary("11", "1"));
    }

    public static String getAddBinary(String A, String B) {

        if (A.length() < B.length()) {
            return getAddBinary(B, A);
        }
        int i = A.length() - 1;
        int j = B.length() - 1;
        StringBuilder str = new StringBuilder();
        int carry = 0;
        while (i >= 0 && j >= 0) {
            if ((A.charAt(i) - '0') == 1 && (B.charAt(j) - '0') == 1) {
                if (carry == 1) {
                    str.append(1);
                } else {
                    str.append(0);
                }
                carry = 1;
            } else if (((A.charAt(i) - '0') == 0 && (B.charAt(j) - '0') == 1) || ((A.charAt(i) - '0') == 1 && (B.charAt(j) - '0') == 0)) {
                if (carry == 1) {
                    str.append(0);
                    carry = 1;
                } else {
                    str.append(1);
                    carry = 0;
                }
            } else {
                if (carry == 1) {
                    str.append(1);
                } else {
                    str.append(A.charAt(i) - '0');
                }
                carry = 0;
            }
            i--;
            j--;
        }

        while (i >= 0) {
            if ((A.charAt(i) - '0') == 1) {
                if (carry == 1) {
                    str.append(0);
                    carry = 1;
                } else {
                    str.append(1);
                }
            } else {
                if (carry == 1) {
                    str.append(1);
                } else {
                    str.append(A.charAt(i) - '0');
                }
                carry = 0;
            }
            i--;
        }

        if (carry == 1) {
            str.append(1);
        }
        return str.reverse().toString();
    }
}
