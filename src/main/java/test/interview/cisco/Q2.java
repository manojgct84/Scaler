package test.interview.cisco;

public class Q2
{

}

class ClassA{
    ClassA() {
        System.out.println ("ClassA Constructor");
    }
    
    protected void show() {
        System.out.println ("ClassA Show");
    }
    
    public static void methodA() {
        System.out.println ("ClassA methodA");
    }
}

class ClassB extends ClassA{
    ClassB() {
        System.out.println ("ClassB Constructor");
        //super();
    }
    
    protected void show() {
        System.out.println ("ClassA Show");
    }
    
    public static void methodA() {
        System.out.println ("ClassA methodA");
    }
}
