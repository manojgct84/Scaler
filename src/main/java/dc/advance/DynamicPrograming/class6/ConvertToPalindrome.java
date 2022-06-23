package dc.advance.DynamicPrograming.class6;

public class ConvertToPalindrome {

    public static void main(String[] args) {
        System.out.println(solve("abcba"));
        System.out.println(solve("abecbea"));
        System.out.println(solve("abcbea"));
    }

    public static int solve(String A) {
       // return convertToPalindrome(A, 0, A.length() - 1);
        return convertToPalindrome(A);
    }

    public static int convertToPalindrome(String A, int start, int end) {

        if (start == end) {
            return 1;
        }
        if (start > end) {
            return 0;
        }

        if (A.charAt(start) == A.charAt(end)) {
            return convertToPalindrome(A, start + 1, end - 1);
        } else {
            if (convertToPalindrome(A, start + 1, end) == 0 ||
                    convertToPalindrome(A, start, end - 1) == 0) {
                return 0;
            }
        }
        return 1;
    }

    public static int convertToPalindrome(String A) {

        int count = 0;
        for (int i = 0; i < (A.length() - 1)/ 2; i++) {
            if (A.charAt(i) != A.charAt(A.length() - i - 1)) {
                count++;
            }
        }
        if (count <= 1) {
            return 1;
        }
        return 0;
    }
}
