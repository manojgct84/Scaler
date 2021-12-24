package dc.clazz.BasicMaths.Assigment.Homework;

public class ReverseInteger {


    public static void main(String[] args) {
        System.out.println(getSolution(-1146467285));
        System.out.println(getSolution(-123));
    }

    private static int getSolution(int n) {

        boolean neg = false;
        if (n < 0) {
            n = Math.abs(n);
            neg = true;
        }
        long res = 0;
        while (n > 0) {
            long r = n % 10;
            res = (res * 10) + r;
            //If it over flows the 32 bits integer.
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            n = n / 10;
        }

        if (neg) {
            res = -1 * res;
        }

        return (int) res;
    }
}
