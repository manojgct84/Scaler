package dc.advance.resursion.reversion.recursion1.homework;

public class FindAthFibonacci {

    public static void main(String[] args) {
        System.out.println(findAthFibonacci(9));
        System.out.println(findAthFibonacci(2));
    }

    public static int findAthFibonacci(int A) {
        if (A == 0) {
            return 0;
        }
        if (A == 1 || A == 2) {
            return 1;
        }

        return findAthFibonacci(A - 1) + findAthFibonacci(A - 2);
    }
}
