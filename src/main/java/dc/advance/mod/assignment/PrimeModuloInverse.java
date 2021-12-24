package dc.advance.mod.assignment;

public class PrimeModuloInverse {

    public static void main(String[] args) {
        System.out.println(getSolve(6, 23));
    }

    public static int getSolve(int A, int B) {
        int result = 1;
        long p = B - 2;
        long a = A;
        while (p > 0) {
            if (p % 2 == 1) {
                result = (int) ((result * a) % B);
                a = (a * a) % B;
                p = (p - 1) / 2;
            } else {
                a = (a * a) % B;
                p >>= 1;
            }
        }
        return result;
    }

    //Using Fermat theorem.
    public static int getFermatSolve(int A, int B) {
        int result = 1;
        long p = B - 2;
        long a = A;
        while (p > 0) {
            if (p % 2 == 1) {
                result = (int) ((result * a) % B);
            }
            a = (a * a) % B;
            p >>= 1;
        }
        return result;
    }
}
