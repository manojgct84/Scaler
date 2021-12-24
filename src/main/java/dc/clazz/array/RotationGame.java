package dc.clazz.array;

import java.util.Scanner;

public class RotationGame {


    public static void main(String[] args) {
        //System.out.println(Arrays.toString(rotateGame2(new int[]{78432416, 39344977, 38228784, 57325761, 60282367, 84265033, 63527579, 15529028, 76229935, 87054738, 47211001, 82731635, 36813982, 4169668, 55914552, 12027462, 17930700, 67817015, 41017139, 54822431, 17267843, 73752906, 22934317, 30372396, 40917027, 58255953, 97430138, 66011487, 88831003, 87563581, 14759687, 62289524, 80043288, 93305932, 60045835, 34775175, 71708982, 13521456, 70916803, 79564495, 47497778, 76891507, 33633753, 25980940, 17495141, 98432856, 34060524, 39503983, 76233890, 78112853, 94992362, 73854302, 99974733, 95940483, 57769085, 95781478, 44868251, 25134768, 62379200, 34620786, 59296114, 73445208, 65521223, 4369329, 58242973, 50948180, 13760741, 83376278, 35078320, 73819927, 42680313, 19906657, 8756890, 27880209, 49060699, 12035297, 24938869, 68320610, 12365383, 1268056, 13268749, 88078150, 59816659, 6843742, 4224998, 16774792, 15097414, 66687149, 32409618, 50596307, 75491843, 89100752, 24980243, 70861700, 29145804, 79514921, 41044171, 98777394, 37895564, 12028885, 42320630, 14979248, 65538576, 23617315, 55136978, 67247368, 12885196, 75497640, 98029519, 51320541, 63540884, 7}, 2)));
        Scanner in = new Scanner(System.in);
        int i = in.nextInt();
        int[] a = new int[i];
        for (int j = 0; j < i; j++) {
            a[j] = in.nextInt();
        }
        int k = in.nextInt();
        // int[] result = rotateGame2(a, k);
        k = k % a.length;
        rotateGame(a, 0, a.length - 1);
        rotateGame(a, k, a.length - 1);
        rotateGame(a, 0, k - 1);
        for (int value : a) {
            System.out.print(value);
            System.out.print(" ");
        }
    }


    private static int[] rotateGame(int[] a, int k) {
        int end = a.length - 1;
        int i = 1;
        if (k == 0) {
            return a;
        }

        while (i <= k) {
            int temp = a[end];
            System.arraycopy(a, 0, a, 1, end - 1 + 1);
            a[0] = temp;
            i++;
        }
        return a;
    }


    private static int[] rotateGame1(int[] a, int k) {
        if (k <= 0 || k > a.length) {
            return a;
        }
        int end = a.length - k;
        int firsthalf = end - 1;
        int[] res = new int[a.length];
        int j = 0;
        while (end < a.length) {
            res[j] = res[end];
            j++;
            end++;
        }
        int i = 0;
        while (i <= firsthalf) {
            res[j] = a[i];
            i++;
            j++;
        }
        return res;
    }

    private static int[] rotateGame2(int[] a, int k) {
        //System.out.println(a.length);
        if (k <= 0) {
            return a;
        }
        k = k % a.length;
        int[] result = new int[a.length];
        for (int i = 0; i < k; i++) {
            result[i] = a[a.length - k + i];
        }

        for (int i = a.length - k - 1; i >= 0; i--) {
            result[i + k] = a[i];
        }
        return result;
    }

    private static void rotateGame(int[] a, int start, int end) {

        while (start < end) {
            int temp = a[start];
            a[start] = a[end];
            a[end] = temp;
            start++;
            end--;
        }
    }
}
