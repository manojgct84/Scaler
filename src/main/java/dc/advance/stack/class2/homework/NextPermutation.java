package dc.advance.stack.class2.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        System.out.println(nextPermutation(new ArrayList<>(Arrays.asList(1, 2, 3))).toString());
        System.out.println(nextPermutation(new ArrayList<>(Arrays.asList(3, 2, 1))).toString());
        System.out.println(nextPermutation(new ArrayList<>(Arrays.asList(769, 533))).toString());
    }

    public static ArrayList<Integer> nextPermutation(ArrayList<Integer> A) {

        int i = A.size() - 1;

        int lessIndex = -1;
        while (i > 0) {
            if (A.get(i - 1) < A.get(i)) {
                lessIndex = i - 1;
                break;
            }
            i--;
        }

        i = A.size() - 1;
        if (lessIndex == -1) {
            reverseArray(A, 0, i);
            return A;
        }
        int greaterIndex = 0;
        while (i >= lessIndex + 1) {
            if (A.get(i) > A.get(lessIndex)) {
                greaterIndex = i;
                break;
            }
            i--;
        }
        swap(A, lessIndex, greaterIndex);
        reverseArray(A, lessIndex + 1, A.size() - 1);
        return A;
    }

    private static void reverseArray(ArrayList<Integer> a, int lessIndex, int length) {
        while (lessIndex < length) {
            swap(a, lessIndex, length);
            length--;
            lessIndex++;
        }
    }

    private static void swap(ArrayList<Integer> a, int lessIndex, int greaterIndex) {
        int temp = a.get(lessIndex);
        a.set(lessIndex, a.get(greaterIndex));
        a.set(greaterIndex, temp);
    }
}
