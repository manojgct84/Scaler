package dc.resursion;

public class ForLoopResursion {

    public static void main(String[] args) {
        System.out.println(forLoop(5));
    }

    public static int forLoop(int n) {
        if (n == 0) {
            return 1;
        }
        int j = 0;
        for (int i = 0; i < n; i++) {
            j += forLoop(n - 1);
            System.out.println(j + " n->" + n);
        }
        return j;
    }
}
