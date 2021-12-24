package dc.advance.mod.assignment;

public class VeryLargePower {

    public static void main(String[] args) {
        System.out.println(getSolve(2, 27));
    }

    public static int getSolve(int A, int B) {
        long fact = 1;
        int mod = 1000000007;
        for (int i = 2; i <= B; i++) {
            fact = (fact * i) % (mod - 1);
        }

        //Fast Power Function
        long result = 1;
        long a = A % mod;
        while (fact > 0) {
            if ((fact & 1) == 1) {
                result = (result * a) % mod;
                a = (a * a) % mod;
                fact = (fact - 1) >> 1; // (fact - 1)/ 2
            } else {
                a = (a * a) % mod;
                fact >>= 1; // fact /=2
            }
        }
        return (int) result;
    }
}
