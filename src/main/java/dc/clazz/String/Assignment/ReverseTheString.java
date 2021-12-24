package dc.clazz.String.Assignment;

public class ReverseTheString {

    public static void main(String args[]) {
        String str = "crulgzfkif gg ombt vemmoxrgf qoddptokkz op xdq hv ";
        //getSolution(str, str.length());
        System.out.println(getSolution(str));
    }

    private static String getSolution(String str) {
        //str = str.trim();
        String[] array = str.split(" ");
        int n = array.length - 1;
        StringBuilder builder = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            if (!(array[i].equals(" ") || array[i].equals(""))) {
                builder.append(array[i]);
                if (i != 0) {
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    } // TC O(N)  SC O(N)
}
