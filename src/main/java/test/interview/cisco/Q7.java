package test.interview.cisco;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class Q7
{
    
    public static void main (String[] args)
    {
        System.out.println("Enter the value in String 1, Jone, true");
        Scanner scanner = new Scanner (System.in);
        Set <Employee> employeeSet = new HashSet <> ();
        
        while (true) {
            try {
                String str = scanner.nextLine ();
                if (str == null || str.isEmpty ()) {
                    break;
                }
                Employee e = createEmployee (str);
                employeeSet.add (e);
            }catch (Exception e) {
                System.out.println (e.getClass ().getName ());
                System.exit (0);
            }
        }
        
        System.out.println ("Employee " + employeeSet);
    }
    
    public static Employee createEmployee(String record) throws InvalidInputException
    {
           String[] token = record.split (",");
           int id = 0;
           boolean gender = true;
           try {
                id = Integer.parseInt (token[0]);
                gender = Boolean.parseBoolean (token[2]);
           } catch (Exception e) {
               throw new  InvalidInputException();
           }
           
           return new Employee (id, token[1], gender);
    }
}

class InvalidInputException extends  Exception {}

class Employee
{
    private int id;
    private String name;
    private boolean male;
    
    Employee (int id ,
              String name ,
              boolean male)
    {
        super ();
        this.id = id;
        this.name = name;
        this.male = male;
    }
    
    @Override
    public boolean equals (Object o)
    {
        if (this == o) {
            return true;
        }
        if (o == null || getClass () != o.getClass ()) {
            return false;
        }
        
        if (!(o instanceof Employee)) {
            return false;
        }
        
        Employee employee = (Employee) o;
        return id == employee.id;
    }
    
    @Override
    public int hashCode ()
    {
        return 31 * id;
    }
}