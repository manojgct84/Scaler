package test.interview.cisco;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Q8
{
    //Lonely prime number in array
    
    public static void main (String[] args)
    {
        String input = "12,3,4,5,5,4,3,2,2,21,23,40,7,6,4,7";
        System.out.println (lonelyPrimeNumber (input));
    }
    
    private static int lonelyPrimeNumber (String input)
    {
        String[] c = input.split (",");
        int[] number = new int[c.length];
    
        for (int i = 0 ; i < c.length ; i++) {
            number[i] = Integer.parseInt (c[i]);
        }
    
        Arrays.sort (number);
        Map<Integer, Integer> freq = new HashMap<>();
    
        for (int value : number) {
            if (freq.containsKey (value)) {
                freq.put (value , freq.get (value) + 1);
            }
            else {
                freq.put (value, 1);
            }
        }
    
        for (int j : number) {
            if (freq.get (j) < 2) {
                int k = 1;
                int prime = j;
                int count = 0;
                while (prime >= k) {
                    if (j % k == 0) {
                        count++;
                    }
                    k++;
                }
                if (count == 2) { // It is prime as  23 / 23 and 23 / 23
                    return j;
                }
            }
        }
        return 0;
    }
}