package dc.advance.Sorting2.Homework;

public class MaxChunksToMakeSorted {

    public static void main(String[] args) {
        System.out.println(getSolve(new int[]{1, 2, 3, 4, 0}));
        System.out.println(getSolve(new int[]{2, 0, 1, 3}));
    }

    public static int getSolve(int[] A) {
        if (A.length == 0) {
            return 0;
        }

        // max = [2] == 2 [count = 1]  and max = [3] == 2 [count = 2]
        int count = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            if (max == i) {
                count++;
            }
        }

       /*Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            int min = A[i];
            int max = A[i];
            while (!stack.isEmpty()) {
                int[] top = stack.peek();
                System.out.println(Arrays.toString(top));
                if (A[i] < top[1]) {
                    max = top[1];
                    min = Math.min(A[i], top[0]);
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(new int[]{min, max});
        }
*/


        //quickSort(A, 0, A.length - 1);
        //System.out.println(Arrays.toString(A));
        return count;
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int pi = partation(a, low, high);
            System.out.println("pi " + pi);
            quickSort(a, low, pi - 1);
            quickSort(a, pi + 1, high);
        }
    }

    private static int partation(int[] a, int low, int high) {
        int pi = a[high];
        int i = low - 1;

        for (int j = low; j < a.length; j++) {
            if (a[j] < pi) {
                i++;
                swapValue(a, i, j);
            }
        }
        swapValue(a, i + 1, high);
        return (i + 1);
    }

    private static void swapValue(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
