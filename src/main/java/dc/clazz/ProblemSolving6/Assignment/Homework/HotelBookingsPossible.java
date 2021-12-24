package dc.clazz.ProblemSolving6.Assignment.Homework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotelBookingsPossible {

    public static void main(String args[]) {
        List<Integer> arrival = new ArrayList<>();
        arrival.add(1);
        arrival.add(3);
        arrival.add(4);
        List<Integer> duration = new ArrayList<>();
        duration.add(12);
        duration.add(8);
        duration.add(6);
        System.out.println(getHotel(arrival, duration, 2));
    }

    public static boolean getHotel(List<Integer> arrive, List<Integer> depart, int K) {
        List<Hotel> lst = new ArrayList<>();
        for (int i = 0; i < arrive.size(); i++) {
            lst.add(new Hotel(arrive.get(i), -1));
            lst.add(new Hotel(depart.get(i), 1));
        }
        lst.sort(new Compare());
        //System.out.println(lst.toString());
        int rooms = Integer.MIN_VALUE;
        int room = 0;
        for (Hotel O : lst) {
            if (O.index == -1) {
                room++;
            } else {
                room--;
            }
            rooms = Math.max(rooms, room);
        }
        //System.out.println(rooms);
        return rooms <= K;
    }
}

class Hotel {
    @Override
    public String toString() {
        return "Hotel{" +
                "arriveDepart=" + arriveDepart +
                ", index=" + index +
                '}';
    }

    int arriveDepart;
    int index;

    public Hotel(int arriveDepart, int index) {
        this.arriveDepart = arriveDepart;
        this.index = index;
    }
}

class Compare implements Comparator<Hotel> {

    @Override
    public int compare(Hotel o1, Hotel o2) {

        if (o1.arriveDepart !=o2.arriveDepart ) {
            return Integer.compare(o1.arriveDepart, o2.arriveDepart);
        } else {
            return Integer.compare(o1.index, o2.index);
        }

    }
}