package dc.advance.resursion.assignment.Homework;

import java.util.ArrayList;

public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        finalCombine(res, new ArrayList<Integer>(), A, B, 1);
        return res;
    }

    private static void
    finalCombine(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int A, int size, int index) {

        if (temp.size() == size) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <=A; i++) {
            if (temp.contains(i)) continue;
            temp.add(i);
            finalCombine(res, temp, A, size, i + 1);
            //  this is shared array for all the stack calls , so we undo the array to previous stack
            temp.remove(temp.size() - 1);

        }
    }
    //Other way of doing it using the bracktracking the index and array.
    private static void
    finalCombineIndex(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int A, int size, int index) {

        if (temp.size() == size) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i <= A; i++) {
            //if (temp.contains(i)) continue;
            temp.add(i);
            finalCombine(res, temp, A, size, index + 1);
            //  this is shared array for all the stack calls , so we undo the array to previous stack
            temp.remove(temp.size() - 1);
            index++; // we need to move to next index and previous call stack index.

        }
    }
}
