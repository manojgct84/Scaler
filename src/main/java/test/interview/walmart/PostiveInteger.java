package test.interview.walmart;

import java.util.Arrays;

public class PostiveInteger {


    public static void main(String args[]) {

        System.out.println(solution(new int[]{-2, -1, 2, 3, 4}));
        System.out.println(solution(new int[]{-3, -2, -1, 1}));
        /*System.out.println(fun(100,2000));
        // System.out.println(fib(6));
        for ( int i =1 ; i < 6 ; i++) {
            System.out.println(fib1(i) + " ");
        }*/
    }

    public static int fun(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return fun(b, a % b);
        }

    }

    public static int fib(int b) {
        if (b <= 1) {
            return b;
        }
        return fib(b - 1) + fib(b - 2);
    }

    public static int fib1(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return 0;
        }

        if (n == 3) {
            return 1;
        } else {
            return fib1(n - 1) + fib1(n - 2) + fib1(n - 3);
        }
    }

    private static int solution(int[] ints) {
        //1,2,3,4
        //2,3,4 = 1
        //-2,-1,2,3,4 = 0,0,2,3,4 = 1
        //-4,-3,-2 = 1
        //-4,-2 = 1
        //-3,-2,-1 , 1 = 2

        Arrays.sort(ints); //O(nlogn)
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > 0) {
                if (ints[i + 1] - ints[i] > 1) {
                    return 1;
                }
                break;
            }
            ints[i] = 0;
        }
        //O(n-m) n- length array , m - negative integer
        //1,2,3,5,7,8,9,10
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i + 1] - ints[i] > 1) {
                return ints[i] + 1;
            }
        }
        //O(n-k)
        return ints[ints.length - 1] + 1;
        //O(log n * n2)
    }
}
