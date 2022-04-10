package dc.advance.DynamicPrograming.class5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlipArray
{
    
    public static void main (String[] args)
    {
        
        System.out.println (flipArray (new ArrayList <> (Arrays.asList (15 , 10 , 6))));
        System.out.println (flipArray (new ArrayList <> (Arrays.asList (14 , 10 , 4))));
    }
    
    public static int flipArray (final List <Integer> A)
    {
        int sum = 0;
        
        for (Integer integer : A) {
            sum += integer;
        }

        int[][] dp = new int[A.size () + 1][(sum / 2) + 1];
        sum = sum / 2;
        
        for (int i = 0 ; i <= sum ; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1 ; i <= A.size () ; i++) {
            for (int j = 0 ; j <= sum ; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A.get (i - 1)) {
                    dp[i][j] = Math.min (dp[i][j], 1 + dp[i - 1][j - A.get (i - 1)]);
                }
            }
        }
        
        while (dp[A.size ()][sum] == Integer.MAX_VALUE) {
            sum--;
        }
        return dp[A.size ()][sum];
    }
}
