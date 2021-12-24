package dc.advance.Searching.Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfArray {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new ArrayList<>(Arrays.asList(1, 4, 5)),
                new ArrayList<>(Arrays.asList(2, 3))));
        System.out.println(findMedianSortedArrays(new ArrayList<>(Arrays.asList(1, 2, 3)),
                new ArrayList<>(Arrays.asList(4))));
        System.out.println(findMedianSortedArrays(new ArrayList<>(Arrays.asList(-50, -41, -40, -19, 5, 21, 28)),
                new ArrayList<>(Arrays.asList(-50, -21, -10))));
    }

    public static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {

        //rotate the array.
        if (a.size() > b.size())
            return findMedianSortedArrays(b, a);

        if (a.size() == 0 && b.size() == 0) {
            return 0;
        } else if (a.size() == 0) {
            if (b.size() % 2 == 0) {
                return (b.get(b.size() / 2 - 1) + b.get(b.size() / 2)) / 2.0;
            } else {
                return (b.get(b.size() / 2));
            }
        } else if (b.size() == 0) {
            if (a.size() % 2 == 0) {
                return (a.get(a.size() / 2 - 1) + a.get(a.size() / 2)) / 2.0;
            } else {
                return (a.get(a.size() / 2));
            }
        }
        int m = a.size(); //[-50, -21, -10]
        int n = b.size(); //[-50, -41, -40, -19, 5, 21, 28]
        int total = m + n;
        int low = 0;
        int high = m;
        int half = (m + n) / 2;  //10 / 2 => 5

        while (low <= high) {
            int midA = low + ((high - low) >> 1); //[-50]
            int midB = half - midA; //5 - 1 = 4 =>[-50, -41, -40, -19, 5]
            if (midA < m && midB > 0 && b.get(midB - 1) > a.get(midA)) {
                low = midA + 1;
            } else if (midA > 0 && a.get(midA - 1) > b.get(midB)) {
                high = midA - 1;
            } else {
                double left, right;
                if (midA == 0) {
                    left = b.get(midB - 1);
                } else if (midB == 0) {
                    left = a.get(midA - 1);
                } else {
                    left = Math.max(a.get(midA - 1), b.get(midB - 1));
                }

                if (midA == a.size()) {
                    right = b.get(midB);
                } else if (midB == n) {
                    right = a.get(midA);
                } else {
                    right = Math.min(a.get(midA), b.get(midB));
                }

                if (total % 2 == 0) {
                    return (left + right) / 2.0;
                } else {
                    return right;
                }
            }
        }



     /*   int[] lst = new int[a.size() + b.size()];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                lst[k++] = a.get(i++);
            } else if (b.get(j) <= a.get(i)) {
                lst[k++] = b.get(j++);
            }
        }

        while (i < a.size()) {
            lst[k++] = a.get(i++);
        }
        while (j < b.size()) {
            lst[k++] = b.get(j++);
        }

        //if length even
        if (lst.length % 2 == 0) {
            return (lst[lst.length / 2 - 1] + lst[lst.length / 2]) / 2.0;
        } else {
            //if length odd
            return (lst[lst.length / 2]);
        }

        int x = 0;
        int y = lst.length - 1;
        //When two pointers meet then it is the result
        while (x <= y) {

            if (x == y) {
                return lst[x];
            }
            x++;
            y--;
        }
        //When two pointers cross each other it is the result
        double x1 = lst[x - 1];
        double y1 = lst[y + 1];

        return (x1 + y1) / 2;*/
        return 0;

    }
}
