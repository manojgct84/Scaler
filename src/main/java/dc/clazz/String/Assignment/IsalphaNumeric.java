package dc.clazz.String.Assignment;

public class IsalphaNumeric {

    public static void main(String[] args) {
         System.out.println(getSolution(new char[]{'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'}));
        //System.out.println(getSolution(new char[]{'N', 'l', 'e', 'V', 'g', 'v', 'r', 'e', 'A', 'H', 'M', 'o', 'F', '?', 's', 'z', 'w', 'f', '`', 's', '?', 'H', 'x', 'B', 'Y', 's', 'M', 'o', 'w', 'K', 'l', 'd', 'T', '@', 'G', 'd', 'p', 'w', 'e', 'g', 'I', 's', 'h', 'O',
          //      'L', 'B', 'd', 'q', 'O', 'q', 'k', 't', 'm', 'c', 'g', 'g', 'M', 'n', 'h', 'v', 'G', 'L', '{', 'a', 'B', 'c', 'x', 'w', 'b', 'x', 'e', '=', 'D', 'i', 'a', 'c', 'y', 'e', 'X', 'p', 'J', 'x', 'e'}));
    }

    public static int getSolution(char[] A) {
        for (char c : A) {
            if (!((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57)))
                return 0;
        }
        return 1;

    }
}
