package dc.clazz.Hash.assignment.day2;

import java.util.HashSet;
import java.util.Set;

public class PairOfSumInArray {

    public static void main(String[] args) {
        System.out.println(getSolution(new int[]{3, 4, 2, 6, 7}));
    }


    //This can be improved. This need to done
    private static int getSolution(int[] A) {

        Set<Integer> set = new HashSet<>();

        for (int k : A) {
            set.add(k);
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = A[i];
            for (int j = i + 1; j < A.length; j++) {
                sum += A[j];
                if (set.contains(sum)) {
                    count++;
                }
            }
        }

        return count;
    }

}