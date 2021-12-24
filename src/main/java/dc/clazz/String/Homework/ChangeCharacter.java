package dc.clazz.String.Homework;

import java.util.Arrays;
import java.util.Comparator;

public class ChangeCharacter {
    public static void main(String args[]) {
        //String str = "aaaaaaaaaabaaaaaaaaa";
        String str = "abcabbccd";
        System.out.println(getSolutionString(str, 3));
    }

    private static int getSolutionString(String str, int B) {
        int[] freq = new int[25];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        System.out.println(Arrays.toString(freq));
        int i = 0;
        while (i < freq.length) {
            if (B >= freq[i]) {
                B -= freq[i];
                freq[i] = 0;
            }
            if (B <= 0) {
                break;
            }
            i++;
        }
        int count = 0;

        for (int k : freq) {
            if (k != 0) {
                count++;
            }
        }
        return count;
    }
}

class Alpha {
    char chars;

    int freq;

    public Alpha(char chars, int freq) {
        this.chars = chars;
        this.freq = freq;
    }
}

class Compare implements Comparator<Alpha> {
    @Override
    public int compare(Alpha o1, Alpha o2) {
        return Integer.compare(o1.freq, o2.freq);
    }
}
