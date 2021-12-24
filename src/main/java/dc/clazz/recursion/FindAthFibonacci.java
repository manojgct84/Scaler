package dc.clazz.recursion;

public class FindAthFibonacci {
    public static void main(String args[]) {
        System.out.println(getSolution(9));
    }

    private static int getSolution(int i) {
        if (i == 0) return 0;
        if (i == 1 || i == 2) {
            return 1;
        }
        return getSolution(i - 1) + getSolution(i - 2);
    }
}
