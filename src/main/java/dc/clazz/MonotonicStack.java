package dc.clazz;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MonotonicStack {

    public static void main(String[] args) {
        System.out.println(getIncreasingMonotonic(new int[]{2, 5, 3, 4, 6, 2}));
        //System.out.println(getDecreasingMonotonic(new int[]{2, 5, 3, 4, 6, 2}));
    }

    private static Stack<Integer> getIncreasingMonotonic(int[] a) {
        Stack<Integer> s = new Stack<>();
        s.push(a[0]);
        List<Integer> index = new ArrayList<>();
        for (int i = 1; i < a.length; i++) {
            while (!s.isEmpty() && a[i] < s.peek()) {
                s.pop();
                index.remove(index.size()-1);
            }
            index.add(i);
            s.push(a[i]);
        }
        System.out.println(index.toString());
        return s;
    }

    private static Stack<Integer> getDecreasingMonotonic(int[] a) {
        Stack<Integer> s = new Stack<>();
        s.push(a[0]);
        List<Integer> index = new ArrayList<>();
        for (int i = 1; i < a.length; i++) {
            while (!s.isEmpty() && a[i] > s.peek()) {
                s.pop();
                //index.remove(i);
            }
            s.push(a[i]);
        }
        System.out.println(index.toString());
        return s;
    }
}
