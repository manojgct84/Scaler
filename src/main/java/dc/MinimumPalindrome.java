package dc;

public class MinimumPalindrome {
    //A = "abede"

    // A = "aabb"

    /**
     * ab - aba - 1
     * aa - 0
     * aabb - aabbaa - 2
     */

    public static void main(String[] args) {
        System.out.println(solve("abcdefd"));
        System.out.println(solve("abaab"));
        System.out.println(interviewBit("oqycntornscygodzdctxnhoc"));
    }

    public static int solve(String str) {
        int count = 0;
        int left = 0;
        int right = str.length() - 1;
        char[] chars = str.toCharArray();
        while (left < right) {
            if (chars[left] != chars[right]) {
                count++;
            } else {
                right--;
            }
            left++;
        }
        return count;
    }
    //A : "oqycntornscygodzdctxnhoc"

    public static int interviewBit(String A) {
        int left = 0;
        int right = A.length() - 1;
        char[] c = A.toCharArray();
        while (left < right) {
            if (c[left] == c[right]) {
                left++;
            } else {
                left = 0;
            }
            right--;
        }
        return A.length() - (right + 1);
    }

    public static int KMPLPS(String A) {
        int left = 0;
        int right = A.length() - 1;
        char[] c = A.toCharArray();
        while (left < right) {
            if (c[left] == c[right]) {
                left++;
            } else {
                left = 0;
            }
            right--;
        }
        return A.length() - (right + 1);
    }
}
