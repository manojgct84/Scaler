package test.interview.amazon;

public class ArthmeticProgression {


    public static void main(String[] args) {
        System.out.println("Output " + getSolve(new int[]{0, 3, 6, 9, 12, 15, 21, 24}));
        System.out.println("Output " + getSolve(new int[]{0, 6}));
        System.out.println("Output " + getSolve(new int[]{1, 5}));
    }

    private static int getSolve(int[] a) {

        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }

        if (a.length == 1) {
            throw new IllegalArgumentException("Array has one element");
        }
        //[1,5]
        if (a.length == 2) {
            if ((a[1] & 1) == 0) {
                return a[0] + a[1] / 2;
            } else {
                throw new IllegalArgumentException("Array has odd elements");
            }
        }

        int max = Integer.MAX_VALUE;
        for (int i = 0; i < a.length - 1; i++) {
            max = Math.min(max, (a[i + 1] - a[i]));
        }
        System.out.println("max:" + max);
        int i = 0;
        while (i < a.length - 1) {
            int current = a[i] + max;
            System.out.println("current " + current);
            if (a[i + 1] != current) {
                return current;
            }
            i++;
        }
        return 0;
    }
}
