package dc.advance.prime.assignment.Homework;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LonelyNumberPrime
{
    public static void main (String[] args)
    {
        String input = "12,3,4,5,5,4,3,2,2,21,23,40,7,6,4,7";
        System.out.println (lonelyPrimeNumber (input));
        String input1 = "2,3,4,6,2,3,4,6,5";
        System.out.println (lonelyPrimeNumber (input1));
    }
    
    private static int lonelyPrimeNumber (String input)
    {
        String[] c = input.split (",");
        int[] number = new int[c.length];
        
        int MAX = Integer.MIN_VALUE;
        for (int i = 0 ; i < c.length ; i++) {
            number[i] = Integer.parseInt (c[i]);
            MAX = Math.max(MAX,number[i] );
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
        
        //Find prime number
        int[] prime = new int[MAX +  1];
        prime[0] = -1;
        prime[1] = -1;
        Arrays.fill (prime,2,prime.length,0);
    
        for (int i = 2 ; i * i <= MAX ; i++) {
              if (prime[i] == 0) {
                  for (int j = i ; j <= MAX ; j = j + i) {
                      prime[j] = 1;
                  }
              }
        }
    
        for (int j : number) {
            if (freq.get (j) < 2) {
                if (prime[j] == 0) {
                    return j;
                }
            }
        }
        
      /*  for (int j : number) {
            if (freq.get (j) < 2) {
                int k = 1;
                int count = 0;
                while (j >= k) {
                    if (j % k == 0) {
                        count++;
                    }
                    k++;
                }
                if (count == 2) { // It is prime as  23 / 23 and 23 / 23
                    return j;
                }
            }
        } */
        return 0;
    }
}
