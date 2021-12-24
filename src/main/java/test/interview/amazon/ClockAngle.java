package test.interview.amazon;

public class ClockAngle {

    public static void main(String[] args) {
        System.out.println(getSolve(7, 43));
    }

    private static int getSolve(int hours, int min) {

        if (hours < 0 || hours > 12) {
            if (hours > 12) {
                hours = hours - 12;
            } else
                return -1;
        }
        if (hours == 12) {
            hours = 0;
        }
        if (min < 0 || min > 60) {
            return -1;
        }

        int h = (360 / 12);
        int m = (360 / 60);

        int hd = (hours + min / 60) * h; // This calculate accurate angle or // hd = 2 * hours
        int md = m * min;
        System.out.println(hd);
        System.out.println(min);
        int angel = 0;
        if (hd < 180 && md < 180) {
            angel = hd - md;
        } else {
            angel = md - hd;
        }

        System.out.println(angel);
        return angel > 180 ? 360 - angel : angel;
    }
}
