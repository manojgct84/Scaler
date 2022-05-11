package dc.advance.array1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SequenceLargestSum
{
    
    public static void main (String[] args)
    {
        System.out.println (Arrays.toString (getLargestSum (new LinkedList <> (Arrays.asList (-4 , 1 , -2 , 2 , 5 , 7 , -2 , 5 ,-11, 9)))));
                                                                                              //0  1   2   3    4  5   6    7   8   9
         System.out.println (Arrays.toString (getLargestSum (new LinkedList <> (Arrays.asList (-4 , -1 , -3 , -5 - 6 - 8 - 2)))));
    }
    //Kadane’s Algorithm:
    private static int[] getLargestSum (List <Integer> input)
    {
        //-4 -3  -5  -3   2   9 ,  7   12 , 1 , 10
        int start;
        int end;
        int newStart = 0;
        int maxVal = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int len = Integer.MIN_VALUE;
        int[] res = new int[2];
        for (int i = 0 ; i < input.size (); i++) {
            maxVal = input.get (i) + maxVal;
            
            if (maxSoFar < maxVal) {
                start = newStart;
                end = i;
                maxSoFar = maxVal;
                int length = start + end;
                if (len < length) {
                    res[0] = start;
                    res[1] = end;
                }
            }
            if (maxVal < 0) {
                maxVal = 0;
                newStart = i + 1;
            }
        }
        return res;
    }
}
