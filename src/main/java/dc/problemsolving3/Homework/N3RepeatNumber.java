package dc.problemsolving3.Homework;

import java.util.ArrayList;
import java.util.List;

public class N3RepeatNumber {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);
        A.add(1);
        A.add(1);

        System.out.println(getSolve(A));
    }

    public static int getSolve(final List<Integer> A) {
        int i = 0;
        int firstCount = 0;
        int secondCount = 0;
        int firstElement = 0;
        int secondElement = 0;

        while (i < A.size()) {
            if (firstElement == A.get(i)) {
                firstCount++;
            } else if (secondElement == A.get(i)) {
                secondCount++;
            } else if (firstCount == 0) {
                firstCount++;
                firstElement = A.get(i);

            } else if (secondCount == 0) {
                secondCount++;
                secondElement = A.get(i);

            } else {
                secondCount--;
                firstCount--;
            }
            i++;
        }

        int count_1 = 0;
        int count_2 = 0;

        for (Integer integer : A) {
            if (integer == firstElement) {
                count_1++;
            }
            if (integer == secondElement) {
                count_2++;
            }
        }

        if (count_2 > A.size() / 3) {
            return secondElement;
        }
        return -1;
    }
}
