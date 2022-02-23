package dc.advance.stack.class2.assignment;

public class AlternatingSequence {
    public static void main(String[] args) {
        System.out.println(getSolve("++-+----"));
        System.out.println(getSolve("++++++"));
    }

    public static int getSolve(String A) {

        char[] c = A.toCharArray();
        int inc = 0;
        int dec = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '+') {
                inc++;
            } else if (c[i] == '-') {
                dec++;
            }
        }
        return Math.max(inc, dec);
    }
}
