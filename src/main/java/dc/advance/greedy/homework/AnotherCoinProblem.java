package dc.advance.greedy.homework;

import java.util.ArrayList;

public class AnotherCoinProblem {
    //1, 5, 25, 125, 625, 3125, 15625
    //Given an integer A denoting the cost of an item, find and return the smallest number of coins
    // necessary to pay exactly the cost of the item
    public static void main(String[] args) {
        System.out.println(anotherCoinProblem(47));
        System.out.println(anotherCoinProblem(9));
        System.out.println(anotherCoinProblem(764));
        System.out.println(anotherCoinProblem(959));
        System.out.println(anotherCoinProblem(35));
    }

    public static int anotherCoinProblem(int A) {
        ArrayList<Integer> fives = new ArrayList<>();
        int i = 1;
        fives.add(1);
        while (i < A) {
            i = i * 5;
            if (i > A) {
                break;
            }
            fives.add(i);
        }

        int coinChange = 0;
        int k = fives.size() - 1;
        while (k > 0) {
            if (A >= fives.get(k)) {
                A = A - fives.get(k);
                coinChange++;
                if (A < fives.get(k)) {
                    k--;
                }
            } else {
                k--;
            }
        }
        return coinChange + A;
    }
}
