package dc.LinkedList.Class1.assignment;

public class JavaObject {
    public static void main(String[] args) {
        Address address0 = new Address(1, 2, "BA");
        Address address1 = new Address(5, 10, "CH");
        address0.next = address1;
        Student student0 = new Student(1, address0);
        solve(student0);
    }

    public static Student solve(Student student) {
        Student current = student;
        current.rollNo = 100;
        current.address.city = "DL";
        current.address.next = new Address(1, 1, "CBE");
        current.address.next.next = new Address(1, 1, "ERODE");
        System.out.println("Current " + current.toString());
        current.address.next = current.address.next.next;
        System.out.println("Head " + student.toString());
        return student;
    }

}


class Student {
    int rollNo;
    Address address;

    public Student(int rollNo, Address address) {
        this.rollNo = rollNo;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", address=" + address +
                '}';
    }

}

class Address {
    int doorNo;
    int streetNo;
    String city;
    Address next;

    public Address(int doorNo, int streetNo, String city) {
        this.doorNo = doorNo;
        this.streetNo = streetNo;
        this.city = city;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Address{" +
                "doorNo=" + doorNo +
                ", streetNo=" + streetNo +
                ", city='" + city + '\'' +
                ", next=" + next +
                '}';
    }
}