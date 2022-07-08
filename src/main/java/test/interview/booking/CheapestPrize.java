package test.interview.booking;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Booking.com
 *
 * Imagine Booking customers want to know the cheapest one-way flights from certain cities within
 * date ranges between `start_day` and `end_day`. In this problem we will focus on a single one-way flight.
 *
 * The data comes from a web service call which is done in the function get_flights. This function
 * is already written for you. For simplicity, days are represented as integers
 *
 * get_flights(start_day: int, end_day: int) -> hashmap<str, hashmap<str, int>>
 *
 * # Example:
 *
 * # get_flights(3, 8)
 *
 * # output ->
 *
 * # {
 *
 * 4: {"price": 300}, # eg. day 4 has a price of 300
 *
 * #
 *
 * # 3: {"price": 100},
 *
 * #
 *
 * # 8: {"price": 100}
 *
 * # }
 *
 * #}
 *
 * # there are many fields in each entry, only "price" is used in this
 *
 * problem
 *
 * Your task is to write the get_cheapest flights function which returns
 *
 * the day with the lowest flight price for every x day range (called
 *
 * `day_range`) between `start_day` and `end_day`
 *
 * # get_cheapest_flights(day_range: int, start_day: int, end_day: int) ->
 * hashmap<str, hashmap< str, int>>
 *
 * # example:
 *
 * # get_cheapest flights(3, 3, 8)
 *
 * #
 *
 * Day
 *
 * 3
 *
 * 4
 *
 * 5
 *
 * 6
 *
 * 100, 300, 500, 500, 200, 100
 *
 * #
 *
 * {100,
 *
 * 300,
 *
 * 500}
 *
 * 7
 *
 * 8
 *
 * # ranges
 *
 * #
 *
 * {300, 500, 500} {500,
 *
 * # prices
 *
 * 200}
 *
 * 500, {500, 200, 100}
 *
 * # expected
 *
 * # output -> {"3-5": {"day": 3, "price": 100},
 *
 * "4-6": {"day": 4, "price": 300},
 *
 * "5-7": {"day": 7, "price": 200}, "6-8": {"day": 8, "price": 100}}
 */
public class CheapestPrize {
    //Sliding Window
    public static void main(String[] args) {
        System.out.println(getCheapestFlights(3, 3, 8));
    }

    public static LinkedHashMap<String, Map<String, String>>
        getCheapestFlights(int dataRange, int startDate, int endDate)
    {
        Map<String, Map<String, String>> price = getFlights(startDate, endDate);
        TreeMap<Integer, Map<String, String>> treeMap = new TreeMap<>();

        for (Map.Entry<String, Map<String, String>> map : price.entrySet()) {
            treeMap.put(Integer.valueOf(map.getKey()), map.getValue());
        }

        // K - size-window - 3
        // 3, 4, 5, 6, 7, 8

        LinkedHashMap<String, Map<String, String>> output = new LinkedHashMap<>();
        Map<String, String> dayPrice;

        int[] priceArray = new int[endDate - startDate + 1];
        int pos = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;
        // Do the first - K range
        for (int i = 0; i < dataRange; i++) {
            Map<String, String> value = treeMap.get(startDate + i);
            value.get("price:");
            if (Integer.parseInt(value.get("price:")) < min) {
                min = Integer.parseInt(value.get("price:"));
                pos = i;
            }
            j = i;
            priceArray[i] = Integer.parseInt(value.get("price:"));
        }

        dayPrice = new HashMap<>();
        dayPrice.put("day:" + (startDate + pos), "price:" + min);
        output.put(startDate + "-" + (startDate + dataRange - 1), dayPrice);

        // Start from the K range and go till the end.

        int k = 1;
        for (int x = dataRange + 1; x <= treeMap.size(); x++) { //O(N-dataRange).
            // TC : O (N-dataRange * dataRange)
            min = Integer.MAX_VALUE;
            // start = 3 + j (here j is 2).
            priceArray[x - 1] = Integer.parseInt(treeMap.get(startDate + j + 1).get("price:"));
            for (int i = k; i < x; i++) {
                if (priceArray[i] < min) {
                    min = priceArray[i];
                    pos = startDate + i;
                }
            }

            dayPrice = new HashMap<>();
            dayPrice.put("day:" + (pos), "price:" + min);
            output.put(x + "-" + (startDate + j + 1), dayPrice);

            k++;
            j++;
        }
        System.out.println(Arrays.toString(priceArray));
        return output;
    }

    private static Map<String, Map<String, String>>
        getFlights(int startDate, int endDate)
    {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();

        lock.unlock();
        Map<String, Map<String, String>> output = new HashMap<>();
        Map<String, String> dayPrice1 = new HashMap<>();
        dayPrice1.put("price:", String.valueOf(300));
        output.put(String.valueOf(3), dayPrice1);

        Map<String, String> dayPrice2 = new HashMap<>();
        dayPrice2.put("price:", String.valueOf(100));
        output.put(String.valueOf(4), dayPrice2);

        Map<String, String> dayPrice3 = new HashMap<>();
        dayPrice3.put("price:", String.valueOf(500));
        output.put(String.valueOf(5), dayPrice3);

        Map<String, String> dayPrice4 = new HashMap<>();
        dayPrice4.put("price:", String.valueOf(200));
        output.put(String.valueOf(6), dayPrice4);


        Map<String, String> dayPrice5 = new HashMap<>();
        dayPrice5.put("price:", String.valueOf(500));
        output.put(String.valueOf(7), dayPrice5);

        Map<String, String> dayPrice6 = new HashMap<>();
        dayPrice6.put("price:", String.valueOf(300));
        output.put(String.valueOf(8), dayPrice6);

        return output;
    }


    public static Map<String, Map<String, String>>
    getOtherCheapestFlights(int dataRange, int startDate, int endDate)
    {
        Map<String, Map<String, String>> price = getFlights(startDate, endDate);
        TreeMap<Integer, Map<String, String>> treeMap = new TreeMap<>();

        for (Map.Entry<String, Map<String, String>> map : price.entrySet()) {
            treeMap.put(Integer.valueOf(map.getKey()), map.getValue());
        }
        // K - size-window - 3
        // 3, 4, 5, 6, 7, 8

        // w += a[k] - a[k-i] // Sliding window
        Map<String, Map<String, String>> output = new HashMap<>();
        Map<String, String> dayPrice;

        int pos = 0;
        int size = treeMap.size();
        for (int x = 0; x < (size - dataRange + 1); x++) { //O(N-dataRange).     TC : O
            // (N-dataRange *
            // dataRange)
            int k = 0;
            int min = Integer.MAX_VALUE;
            while (k < dataRange) {  //O(N)
                Map<String, String> value = treeMap.get(startDate + k);
                value.get("price:");
                if (Integer.parseInt(value.get("price:")) < min) {
                    min = Integer.parseInt(value.get("price:"));
                    pos = k;
                }
                k++;
            }
            dayPrice = new HashMap<>();
            dayPrice.put("day:" + (startDate + pos), "price:" + min);
            output.put(startDate + "-" + (startDate + dataRange - 1), dayPrice);
            startDate = startDate + 1;
        }
        return output;
    }
}
