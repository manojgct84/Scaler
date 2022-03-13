package dc.advance.greedy.assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class AssignMiceToHoles {

    public static void main(String[] args) {
        System.out.println(assignMiceToHoles(new ArrayList<>(Arrays.asList(-4, 2, 3)),
                new ArrayList<>(Arrays.asList(0, -2, 4))));
        System.out.println(assignMiceToHoles(new ArrayList<>(Arrays.asList(-2)),
                new ArrayList<>(Arrays.asList(-6))));
    }
    public static int assignMiceToHoles(ArrayList<Integer> A, ArrayList<Integer> B) {

        Collections.sort(A);
        Collections.sort(B);

        int max =0;

        for (int i =0; i< A.size(); i++) {
            max = Math.max(max, Math.abs(A.get(i)- B.get(i)));
        }

        return  max;

    }

}
