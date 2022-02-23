package dc.advance.Trees.BST.class3.homework;

public class CheckBSTOneChild {

    public static void main(String[] args) {
        System.out.println(checkBSTOneChild(new int[]{4, 10, 5, 8}));
        System.out.println(checkBSTOneChild(new int[]{1, 5, 6, 4}));
    }

    public static String checkBSTOneChild(int[] A) {
        int min = Math.min(A[A.length - 1], A[A.length - 2]);
        int max = Math.max(A[A.length - 1], A[A.length - 2]);

        for (int i = A.length - 3; i >= 0; i--) {
            if (A[i] < min) {
                min = A[i];
            } else if (A[i] > max) {
                max = A[i];
            } else {
                return "NO";
            }
        }
        return "YES";
    }
}
