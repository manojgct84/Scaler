package dc.advance.resursion.reversion.recursion1.homework;

public class FindFactorial
{
    public static void main (String[] args)
    {
        System.out.println (solve (4));
        System.out.println (solve (1));
    }
    
    public static int solve (int A)
    {
        if (A == 1) {
            return 1;
        }
        return A  * solve (A - 1) ;
    }
}
