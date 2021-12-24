package dc.clazz.String.Homework;

public class ClosestPalindrome {

    public static void main(String args[]) {
        String str = "aaaaaaaaaabaaaaaaaaa";
        System.out.println(getSolutionString(str));
    }

    private static String getSolutionString(String str) {


        int n = str.length();
        int i = 0;
        int j = n - 1;
        int odd = 0;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                odd++;
            }
            i++;
            j--;
        }


        if (str.length() % 2 == 0) {
            if (odd == 1) {
                return "YES";
            }
        } else {
            if (odd == 0 || odd == 1) {
                return "YES";
            }
        }
        return "NO";
    }
}
