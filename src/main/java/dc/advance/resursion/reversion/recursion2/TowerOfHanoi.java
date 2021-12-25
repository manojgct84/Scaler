package dc.advance.resursion.reversion.recursion2;

import java.util.ArrayList;

public class TowerOfHanoi {
    public static void main(String[] args) {
        System.out.println(towerOfHanoi(2));
    }

    public static ArrayList<ArrayList<Integer>> towerOfHanoi(int A) {
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        towerOfHanoiSolution(A, 1, 2, 3, lst, new ArrayList<>());
        return lst;
    }

    private static void towerOfHanoiSolution
            (int a, int src, int temp, int dest,
             ArrayList<ArrayList<Integer>> lst, ArrayList<Integer> tempList) {
        if (a == 0) {
            return;
        }
        towerOfHanoiSolution(a - 1, src, dest, temp, lst, tempList);
        tempList.add(a);
        tempList.add(src);
        tempList.add(dest);
        lst.add(new ArrayList<>(tempList));
        tempList.removeAll(tempList);
        towerOfHanoiSolution(a - 1, temp, src, dest, lst, tempList);
    }
}
