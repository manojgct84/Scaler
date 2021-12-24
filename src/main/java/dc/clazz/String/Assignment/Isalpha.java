package dc.clazz.String.Assignment;

public class Isalpha {
    public static void main(String[] args) {
        // System.out.println(getSolution(new char[]{'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'}));
        System.out.println(getSolution(new char[]{'N', 'l', 'e', 'V', 'g', 'v', 'r', 'e', 'A', 'H', 'M', 'o', 'F', '?', 's', 'z', 'w', 'f', '`', 's', '?', 'H', 'x', 'B', 'Y', 's', 'M', 'o', 'w', 'K', 'l', 'd', 'T', '@', 'G', 'd', 'p', 'w', 'e', 'g', 'I', 's', 'h', 'O',
                'L', 'B', 'd', 'q', 'O', 'q', 'k', 't', 'm', 'c', 'g', 'g', 'M', 'n', 'h', 'v', 'G', 'L', '{', 'a', 'B', 'c', 'x', 'w', 'b', 'x', 'e', '=', 'D', 'i', 'a', 'c', 'y', 'e', 'X', 'p', 'J', 'x', 'e'}));
    }

    private static int getSolution(char[] chars) {
        for (char aChar : chars) {
            if (!((aChar >= 65 && aChar <= 90) || (aChar >= 97 && aChar <= 122)))
                return 0;
        }
        return 1;
    }
}
