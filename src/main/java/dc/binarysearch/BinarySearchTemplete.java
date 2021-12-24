package dc.binarysearch;

public class BinarySearchTemplete {

    public static void main(String[] args) {
        // binarySearch3(new int[]{1, 2, 3, 4}, 1);
        binarySearch1(new int[]{1, 2, 3, 4, 6, 7, 8}, 6);
        binarySearch5(50);
    }

    private static int binarySearch1(int[] num, int target) {
        int a = 29;
        System.out.println(~a);
        int low = 0, high = num.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private static int binarySearch2(int[] num, int target) {
        int low = 0, high = num.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return num[high] == target ? high : -1;
    }

    //If there are only two elements then you do need to do search
    private static void binarySearch3(int[] num, int target) {
        int low = 0, high = num.length - 1;

        while (low + 1 < high) {
            int mid = low + (high - low) / 2;
            if (num[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (num[low] != target && num[high] != target) {
            System.out.println(-1);
        } else {
            int res = num[low] == target ? low : high;
            System.out.println(res);
        }
    }

    private static void binarySearch4(int[] num, int target) {
        int low = 0, n = num.length;

        for (int jump = n / 2; jump >= 1; jump /= 2) {
            while (low + jump < n && num[low + jump] <= target) {
                low += jump;
            }
        }
        System.out.println(num[low] == target ? low : -1);
    }


    //Sqrt problem.
    private static void binarySearch5(int target) {
        int low = 1;
        int high = target;
        int ans_sqrt = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int sqrt = mid * mid;
            if (sqrt == mid) {
                System.out.println(mid);
                break;
            }
            if (mid <= target/mid) {
                low = mid + 1;
                ans_sqrt = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(ans_sqrt);

    }
}
