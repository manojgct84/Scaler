package dc.clazz.recursion;

public class SumOfDigits {

    public static void main(String args[]) {
        System.out.println(getSolution(100));
    }

    private static int getSolution(int A) {

        if (A < 9) {
            return A;
        }

        return A % 10 + getSolution(A / 10);
    }
}
