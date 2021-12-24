package dc.clazz.BasicMaths.Assigment.day2;

public class WhoSurvivesInCircle {

    public static void main(String[] args) {
        System.out.println(getSolution(100));
    }

    private static int getSolution(int i) {
        String bin = Integer.toBinaryString(i);
        System.out.println(bin);
        String lastbit = bin.substring(0, 1);
        System.out.println(lastbit);
        String rem = bin.substring(1);
        System.out.println(rem);
        System.out.println( rem + lastbit);
        return Integer.parseInt((rem + lastbit), 2);
    }
}
