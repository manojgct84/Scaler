package dc.clazz.String.Assignment;

public class RotateString {
    public static void main(String args[]) {
        String str = "scaler";
        otherSolution(str, 2);
        System.out.println(getSolution(str, 7));
    }

    //Best solution to rotate a array for a given B.
    private static String getSolution(String a, int k) {

        char[] c = a.toCharArray();
        int i = k % a.length();
        if (i == 0) {
            return a;
        }
        rotateGame(c, 0, c.length - 1);
        rotateGame(c, i, c.length - 1);
        rotateGame(c, 0, i - 1);
        return String.valueOf(c);
    } //TC - O(N) & SC - O(1)

    private static void rotateGame(char[] a, int start, int end) {

        while (start < end) {
            char temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }


    private static void otherSolution(String str, int B) {
        char[] chars = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            int index = (i + B) % str.length();
            System.out.println(index);
            chars[index] = str.charAt(i);
        }
        System.out.println(String.valueOf(chars));
    }

    //TC - O(N) & SC - O(N)
}
