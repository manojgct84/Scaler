package dc.clazz.BasicMaths.Assigment.Homework;

public class GridUniquePaths {

    public static void main(String[] args) {
        System.out.println(getSoultion(3, 3));
    }

    private static int getSoultion(int n, int m) {
        if (n == 0 && m == 0) {
            return 0;
        }
        //nCr -  (m + n – 2)! / (n – 1)! * (m – 1)!
        long res = 1;
        int N = m + n - 2;
        int r = Math.min(m - 1, n - 1); // This is take the min path steps - (n – 1)! * (m – 1)!
        for (int i = 1; i <= r; i++) {
            res *= (N - r + i);
            res /= i;
        }
        return (int) res;
    }
}
