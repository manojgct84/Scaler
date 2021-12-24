package dc.clazz.Sorting.Assignment.HomeWork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MinimizeDifference {

    public static void main(String[] args) {
        System.out.println((getSolutionHasHMap(new int[]{1, 1, 7}, 7)));
        System.out.println((getSolutionHasHMap(new int[]{2, 6, 3, 9, 8}, 3)));
        System.out.println((getSolutionHasHMap(new int[]{4, 6, 3, 1, 4}, 5)));
        System.out.println((getSolutionHasHMap(new int[]{2, 8, 3, 7, 8, 7, 9}, 9)));

    }

    //Not for all cases
    private static int getSolution(int[] A, int B) {
        if (A.length == 1 && B == 1) {
            return A[0];
        }
        Arrays.sort(A);
        if (A.length == 2 && B == 1) {
            int a = A[A.length - 1] - 1;
            A[A.length - 1] = a;
            return A[A.length - 1] - A[0];
        }

        //boolean toggle = false;
        //System.out.println(Arrays.toString(A));
        while (B > 0) {
            int max = Arrays.stream(A).max().getAsInt();
            int min = Arrays.stream(A).min().getAsInt();
            int minIndex = indexOf(A, min);
            int maxIndex = indexOf(A, max);
            if (max - min == 0) {
                return 0;
            }
            if (A[minIndex] < A[minIndex + 1]) {
                int a = A[minIndex] + 1;
                A[minIndex] = a;
            } else if (A[maxIndex] >= A[maxIndex - 1]) {
                int a = A[maxIndex] - 1;
                A[maxIndex] = a;
            }
            System.out.println(Arrays.toString(A));
            B--;
        }
        System.out.println(Arrays.toString(A));

        int max = Arrays.stream(A).max().getAsInt();
        int min = Arrays.stream(A).min().getAsInt();
        return max - min;
    }

    public static int indexOf(int[] arr, int val) {
        return IntStream.range(0, arr.length)
                .filter(i -> val == arr[i])
                .findFirst() // first occurrence
                .orElse(-1);
    }

    /**
     * 1. Have HashMap Freq
     * 2. Have the min and max value
     * 3. In the while loop or for  B> 0
     * 4. map.put (min +1, get(min) +1) & map.put (max +1, get(max) +1)
     * 5. B -=min [ min = min + 1]
     * 6. B -=max [ max = max + 1]
     * 7. max  -min
     */
    //Worked for me
    private static int getSolutionHasHMap(int[] A, int B) {
        if (A.length == 1 && B == 1) {
            return A[0];
        }
        //Arrays.sort(A);
        if (A.length == 2 && B == 1) {
            int a = A[A.length - 1] - 1;
            A[A.length - 1] = a;
            return A[A.length - 1] - A[0];
        }

        Map<Integer, Integer> a = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : A) {
            min = Math.min(min, i);
            max = Math.max(max, i);
            a.put(i, a.getOrDefault(i, 0) + 1);
            /*if (a.containsKey(j)) {
                a.put(j, a.get(j) + 1);
            } else {
                a.put(j, 1);
            }*/
        }
      /*  int[] freq = new int[Arrays.stream(A).max().getAsInt() + 1];
        Arrays.fill(freq, 0);

        for (int i = 0; i < A.length; i++) {
            freq[A[i]]++;
        }*/

        System.out.println("min " + min + "max " + max);
        int l = 0;
        int r = A.length - 1;

        while (B > 0 && min < max) {
            if (a.get(min) < a.get(max)) {
                if (B < a.get(min))
                    break;
                a.put(min + 1, a.getOrDefault(min + 1,0) + a.get(min));
                B -= a.get(min);
                min = min + 1;
            } else {
                if (B < a.get(max))
                    break;
                a.put(max - 1, a.getOrDefault(max - 1,0) + a.get(max));
                B -= a.get(max);
                max = max - 1;
            }
        }
        return max - min;
    }



}
