package dc.clazz.String.Assignment;

public class Toupper {
    public static void main(String[] args) {
        // System.out.println(getSolution(new char[]{'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'}));
        System.out.println(getSolution(new char[]{'N', 'l', 'e', 'V', 'g', 'v', 'r', 'e', 'A', 'H', 'M', 'o', 'F', '?', 's', 'z', 'w', 'f', '`', 's', '?', 'H', 'x', 'B', 'Y', 's', 'M', 'o', 'w', 'K', 'l', 'd', 'T', '@', 'G', 'd', 'p', 'w', 'e', 'g', 'I', 's', 'h', 'O',
                'L', 'B', 'd', 'q', 'O', 'q', 'k', 't', 'm', 'c', 'g', 'g', 'M', 'n', 'h', 'v', 'G', 'L', '{', 'a', 'B', 'c', 'x', 'w', 'b', 'x', 'e', '=', 'D', 'i', 'a', 'c', 'y', 'e', 'X', 'p', 'J', 'x', 'e'}));
    }

    private static char[] getSolution(char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 97 && chars[i] <= 122)
                chars[i] ^=32;
        }
        String s = "scaler".toLowerCase();
        return chars;
    }

}
