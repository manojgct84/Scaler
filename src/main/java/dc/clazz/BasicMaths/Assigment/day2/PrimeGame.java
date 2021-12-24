package dc.clazz.BasicMaths.Assigment.day2;

public class PrimeGame {

    public static void main(String[] args) {
        System.out.println(getSolution(10, 5));
    }

    private static int getSolution(int A, int B) {

        if (B == 1) {
            return 2;
        }

        if (A % 2 == 0) {
            return 2;
        }
        return 1;
    }
}
