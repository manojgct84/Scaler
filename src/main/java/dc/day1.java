package dc;

import java.util.List;

public class day1 {

    /**
     * The government wants to set up B distribution offices across N cities for the distribution of food
     * packets. The population of the ith city is A[i]. Each city must have at least 1 office, and people can go to an
     * office of their own city. We want to maximize the minimum number of people who can get food in any single office.
     * @param args
     */
    public static void main(String args[]) {
        //System.out.println(solve(new ArrayList<>(Arrays.asList(15,18,5)), 7));

         int n = 5 ;

         //System.out.println(sum(n));

        System.out.println(fab(n));

    }

    private static int sum(int n) {
        if (n <= 0) {
              return 0;
         }
        return n + sum(n - 1);
    }

    private static int fab(int n) {
        if (n <= 1) {
            return 1;
        }
        return fab(n - 1) + fab(n - 1);
    }


    public static int solve(final List<Integer> A, final int B) {

    int sum = 0;
    int min = Integer.MAX_VALUE;
        for (int i : A) {
        sum += i;
        min = Math.min(min, i);
    }
    if (sum < B) {
        return 0;
    }

    //Collections.sort(A);
    int low = 1;
    int high = min;
    int ans = 0;
        while (low <= high) {
        int mid = (high + low) / 2;
        if (check(mid, A, B)) {
            ans = mid;
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
        return ans;
}

    private static boolean check(int mid,  List<Integer> a, int b) {
        int req = 0;
        for (int i : a) {
            req += i / mid;
        }
        return (req >= b);
    }
}
