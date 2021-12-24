package dc.clazz.Hash.assignment;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;


//This is Monotonic increasing of two sum calculation.
public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getSolution(new int[]{3, 2, 3}, 6)));
    }

    //2,7,11,15
    private static int[] getMonotonicSolution(int[] A, int B) {
        Deque<Pair> q = new ArrayDeque<>();
        int sum = A[0];
        q.add(new Pair(1, A[0]));
        //q= 2, 7     sum = 7+2 = 9
        for (int i = 1; i < A.length; i++) {
            if (sum == B) break;
            while (!q.isEmpty() && A[i] < q.peek().getValue()) {
                sum = sum - q.pop().getValue();
            }
            if (sum < B) {
                sum += A[i];
                q.add(new Pair(i + 1, A[i]));
            }
        }
        int[] res = new int[q.size()];
        int i = 0;
        while (!q.isEmpty()) {
            res[i] = q.pop().getIndex();
            i++;
        }
        return res;
    }


    private static int[] getSolution(int[] A, int B) {
        //index, value
        Map<Integer, Integer> map = new HashMap<>();
        //3, 2, 3 , B= 6
        // 3,1 , 2,0;
        for (int i = 0; i < A.length; i++) {
            if (map.containsKey(A[i])) {
                int index = map.get(A[i]);
                return new int[]{index, i};
            } else {
                map.put(B - A[i], i);
            }

        }

        return new int[2];
    }
}

class Pair {
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Pair(int index, int value) {
        this.index = index;
        this.value = value;
    }

    int index;
    int value;
}