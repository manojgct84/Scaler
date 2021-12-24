package test.interview.amazon;

import java.util.ArrayList;
import java.util.List;

public class AmazonTest {

    public static void main(String args[]) {
        List<Integer> wheel = new ArrayList<>();
        wheel.add(6);
        wheel.add(3);
        wheel.add(2);
        System.out.println(getSolution(wheel).toString());
    }

    private static List<Integer> getSolution(List<Integer> wheels) {
        List<Integer> res = new ArrayList<>();
        if (wheels.size() == 0) {
            return res;
        }
          for (Integer w : wheels) {
            int count = 0;
            if (w % 2 == 0) {
                count = w / 4 + 1;
                res.add(count);
            } else {
                res.add(0);
            }
        }

       /* for (int i = 0; i < wheels.size(); i++) {
            if (wheels.get(i) % 2 != 0) {
                wheels.set(i, 0);
                continue;
            }
            int numOfWays = wheels.get(i) / 4 + 1;
            wheels.set(i, numOfWays);
        }
        return wheels;*/
        return res;
    }
}
