package dc.clazz.String.Homework;

public class CountOccurrences {
    public static void main(String args[]) {
        String str = "bobabtbobl";
        System.out.println(getSolutionString(str));
    }

    private static int getSolutionString(String str) {
        /*int[] freq = new int[25];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        System.out.println(Arrays.toString(freq));
        return freq[1] - 1;*/
        if (str.length() < 3) {
            return 0;
        }
        int i = 0;
        int n = str.length() - 1;
        int count = 0;
        while (i < n - 1) {
            if (str.charAt(i) == 'b' && str.charAt(i + 1) == 'o' && str.charAt(i + 2) == 'b') {
                count++;
                i +=2;
            } else {
                i++;
            }
        } //TC O(N)
        return count;
    }
}
