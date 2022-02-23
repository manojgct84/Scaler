package dc.advance.Queue.homework.assignment;

import java.util.LinkedList;
import java.util.Queue;

public class PerfectNumbers {

    public static void main(String[] args) {
        System.out.println(solve(4));
    }

    public static String solve(int A) {

        Queue<String> q = new LinkedList<>();

        /*for (int i = 1; i <= A; i++) {
            q.add(i * 10 + i);
        }
        System.out.println(q.toString());
        StringBuilder build = new StringBuilder();

        while (!q.isEmpty()) {
            build.append(q.poll());
        }
        StringBuilder temp = new StringBuilder(build);
        String str = temp.substring(0, temp.length() - 2);
        temp.delete(0, temp.length());
        temp.append(str);
        build.append(temp.reverse());*/

        for (int i = 1; i <= 2; i++) {
            q.add("" + i);
        }
        int count = 0;
        StringBuilder res = new StringBuilder();
        while (!q.isEmpty()) {
            String j = q.poll();
            count++;
            if (count == A) {
                res.append(j);
                StringBuilder temp = new StringBuilder(j);
                temp.reverse();
                res.append(temp);
                break;
            }
            for (int i = 1; i <= 2; i++) {
                q.add(j + i);
            }
        }
        return res.toString();
    }
}
