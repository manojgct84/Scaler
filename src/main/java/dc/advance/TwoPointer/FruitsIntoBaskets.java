package dc.advance.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBaskets
{
    
    public static void main (String[] args)
    {
        System.out.println (totalFruits (new int[] {3 , 3 , 3 , 1 , 2 , 1 , 1 , 2 , 3 , 3 , 4}));
    }
    
    private static int totalFruits (int[] tree)
    {
        Map <Integer, Integer> map = new HashMap <> ();
        int start = 0, end = 0, count = 0, len = 0;
        
        while (end < tree.length) {
            int a = tree[end];
            map.put (a , map.getOrDefault (a , 0) + 1);
            if (map.get (a) == 1) {
                count++;
            }
            end++;
            
            while (count > 2) {
                int temp = tree[start];
                map.put (temp , map.get (temp) - 1);
                if (map.get (temp) == 0) {
                    count--;
                }
                start++;
            }
            len = Math.max (end - start + 1 , len);
        }
        return len;
    }
}