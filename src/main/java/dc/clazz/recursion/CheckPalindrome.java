package dc.clazz.recursion;

public class CheckPalindrome {

    public static void main(String[] args) {
        System.out.println(getSolution("naman"));
    }

    private static int getSolution(String strings) {

        if (strings.length() == 0 || strings.length() == 1) {
            return 1;
        }

        if (strings.charAt(0) == strings.charAt(strings.length() - 1)) {
            return getSolution(strings.substring(1, strings.length() - 1));
        } else {
            return 0;
        }
    }
}
