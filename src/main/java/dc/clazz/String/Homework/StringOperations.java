package dc.clazz.String.Homework;

import java.util.HashSet;
import java.util.Set;

public class StringOperations {

    public static void main(String[] args) {
        String str = "hgUe";
        System.out.println(getSolutionString(str));
    }

    private static String getSolutionString(String str) {
        str = str.concat(str).intern();
        char[] ch = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        System.out.println(str);
        for (char c : ch) {
            if (!(c >= 65 && c <= 90)) {
                if (vowels.contains(c)) {
                    builder.append("#");
                } else {
                    builder.append(c);
                }
            }
        }
        return builder.toString();
    }
}
