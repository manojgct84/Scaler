package dc.clazz.recursion;

public class StringReverse {
    private static StringBuilder result;

    public static void main(String args[]) {
        String str = "abcdef";
        //getSolution(str, str.length());
        System.out.println(getSolution(str));
    }

    private static void getSolution(String str, int n) {
        if (n == 1 || n == 0) {
            System.out.print(str);
        } else {
            getSolution(str.substring(1), n - 1);
            System.out.print(str.charAt(0));
        }
    }

    private static String getSolution(String str) {
      /*  if (str.length() == 0) {
            return str;
        } else {
            return getSolution(str.substring(1)) + str.charAt(0);
        }*/

        int i = 0;
        int j = str.length() - 1;
        char[] c = str.toCharArray();
        while (i < j) {
            swap(i, j, c);
            i++;
            j--;
        }
        return String.valueOf(c);
    }

    private static void swap(int i, int j, char[] str) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
