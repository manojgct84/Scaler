package test.interview.cisco;

public class Q4
{
    public static void main(String[] args) {
        Thread t = new MyThread() {
            @Override
            public void run ()
            {
                System.out.print("Hi");
            }
        };
        t.start();
    }
}

class MyThread  extends Thread{
    
    MyThread() {
        System.out.print ("MyThread");
    }
    
    @Override
    public void run() {
        System.out.print("run");
    }
    
    public void run(String s) {
        System.out.print("run String");
    }
    
}