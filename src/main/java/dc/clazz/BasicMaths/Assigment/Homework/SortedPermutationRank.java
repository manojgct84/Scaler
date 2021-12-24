package dc.clazz.BasicMaths.Assigment.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedPermutationRank {
    public static void main(String[] args) {
        //   System.out.println(getSolveRankRecursion("DTNGJPURFHYEW"));
        System.out.println(getSolveRank("VIEW"));
    }
    //Take dict way (Stored order) V_ _ _ (3 way) and 2 letter less than V - 2*3! ways
    private static int getSolveRank(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int result = 1;
        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) < str.charAt(i)) {
                    count++;
                }
            }
            result = ((int) (result + count * fact(str.length() - 1 - i))) % 1000003;
        }
        return result % 1000003;
    }

    private static long fact(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = (fact * i) % 1000003;
        }
        return fact % 1000003;
    }

    static List<String> result = new ArrayList<>();

    private static int getSolveRankRecursion(String str) {
        permutations(str, "");
        Collections.sort(result);
        System.out.println(result.toString());
        for (int i = 0; i < result.size(); i++) {
            if (str.equals(result.get(i))) {
                return i + 1;
            }
        }
        return 0;
    }

    private static void permutations(String str, String res) {
        if (str == null || str.length() == 0) {
            result.add(res);
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            String pre = res + str.charAt(i);
            String newRemaining = str.substring(0, i) + str.substring(i + 1);
            permutations(newRemaining, pre);
        }
    }


}
