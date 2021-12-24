package dc.clazz.BasicMaths.Assigment;

import java.util.ArrayList;

public class RearrangeArray {
    public static void main(String[] args) {
        //int[] a = {4, 0, 2, 1, 3};
        ArrayList<Integer> a = new ArrayList<>();
        a.add(4);
        a.add(0);
        a.add(2);
        a.add(1);
        a.add(3);
        getSolution(a);
    }

    //Good problem to store two values in a pair in single index in an array
    private static void getSolution(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < A.size(); i++) {
            int a = A.get(i) + (A.get(A.get(i)) % n) * n;
            A.set(i, a);
        }
        for (int i = 0; i < A.size(); i++) {
            A.set(i, A.get(i) / n);
        }
        System.out.println(A);
    }
}
