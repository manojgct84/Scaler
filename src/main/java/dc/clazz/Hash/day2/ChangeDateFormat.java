package dc.clazz.Hash.day2;

import java.util.HashMap;
import java.util.Map;

public class ChangeDateFormat {

    public static void main(String[] args) {
        System.out.println(getSolutionRepString("3rd Jul 3532"));
    }

    private static String getSolutionRepString(String str) {
        //{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        Map<String, Integer> map = new HashMap<>();
        map.put("Jan", 1);
        map.put("Feb", 2);
        map.put("Mar", 3);
        map.put("Apr", 4);
        map.put("May", 5);
        map.put("Jun", 6);
        map.put("Jul", 7);
        map.put("Aug", 8);
        map.put("Sep", 9);
        map.put("Oct", 10);
        map.put("Nov", 11);
        map.put("Dec", 12);

        String[] a = str.split(" ");

        StringBuilder format = new StringBuilder();

        for (int i = a.length - 1; i >= 0; i--) {

            if (i == 2) {
                format.append(a[i]).append("-");
            } else if (i == 1 && map.containsKey(a[i])) {
                if (map.get(a[i]) < 10) {
                    format.append("0").append(map.get(a[i])).append("-");
                } else {
                    format.append(map.get(a[i])).append("-");
                }
            } else {
                int day = Integer.parseInt(a[i].substring(0, a[i].length() - 2));
                if (day < 10) {
                    format.append("0").append(day);
                } else {
                    format.append(day);
                }
            }
        }
        return format.toString();
    }
}