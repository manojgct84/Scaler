package dc.advance.prime.assignment;

public class NumberOfOpenDoors {

    public static void main(String[] args) {
        System.out.println(getSolve(6));
    }
    public static int getSolve(int A) {

        return (int) Math.floor(Math.sqrt(A));
    }
}
