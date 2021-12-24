package dc.advance.mod.assignment.Homework;

public class FindingPosition {

    public static void main(String[] args) {
        System.out.println(getSolve(20));
    }

    public static int getSolve(int A) {
        int base = (int) (Math.log(A) / Math.log(2));
        return (int) Math.pow(2, base);
    }
}
