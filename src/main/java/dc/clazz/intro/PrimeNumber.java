package dc.clazz.intro;

public class PrimeNumber {

    public static void main(String[] args) {
        primeSolve(17);
    }

    private static void primeSolve(int A) {

        System.out.println(Math.sqrt(A));
        int i = 2;
        while (i < Math.sqrt(A)) {
            if (A % i == 0) {
               System.out.println("Not a prime : A / i " + A + "/" + i);
            }
            i++;
        }

    }
}
