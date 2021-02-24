import java.util.concurrent.atomic.AtomicInteger;
class Counter extends Thread{
AtomicInteger count;
Counter(){
count=new AtomicInteger();
}
public void run() {
for (int i=0;i<1000;i++)
count.addAndGet(1);
}
}
public class Q12 {
public static void main(String[] args) {
Counter c = new Counter();
Thread first = new Thread(c , "First");
Thread second = new Thread(c , "Second");
first.start();
second.start();
try {
first.join();
second.join();
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println(c.count);
}
}