package dc.advance.resursion.assignment;

public class SIXLETS {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{5, 17, 1000, 11}, 4));
        System.out.println(getSolve(new int[]{1, 2, 8}, 2));
    }

    public static int getSolve(int[] A, int B) {
        int sum = 0;
        int index = 0;
        return findSubsequencesSum(A, index, sum, B);
    }

    private static int findSubsequencesSum(int[] a, int index, int sum, int size) {

        if (sum > 1000) {
            return 0;
        }
        if (size == 0) {
            return 1;
        }
        if (index == a.length) {
            return 0;
        }

        return findSubsequencesSum(a, index + 1, sum + a[index], size - 1) +
                findSubsequencesSum(a, index + 1, sum, size);
    }
}
