package dc.advance.mod.assignment;

public class ABandModule {

    public static void main(String[] args) {
        System.out.println(getSolve(5, 10));
    }

    public static int getSolve(int A, int B) {

        if (A != B) {
            return Math.max(A, B) - Math.min(A, B);
        }
        return 0;
    }
}
