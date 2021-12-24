package dc.advance.gcd.Homework;

public class DivisorGame {

    public static void main(String[] args) {
        System.out.println(geSolve(12, 3, 2));
    }


    //We need to find the multiples of the both B and C so it will be 6 and 12 for A = 12.
    //need to find lcm = B and C .
    //Math property  = gcd(B,C) * lcm(B,C) = B * C ==> lcm(B,C) = B*C/ gcd(b,c)
    public static int geSolve(int A, int B, int C) {
        int val = gcd(B, C);
        int lcm = (B * C) / val;
        return Math.floorDiv(A, lcm);
    }

    private static int gcd(int b, int c) {
        while (c > 0) {
            int temp = c;
            c = b % c;
            b = temp;
        }
        return b;
    }
}


