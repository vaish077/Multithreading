import java.util.Scanner;
class demo{
public void produce() {
synchronized (this){
System.out.println("Producer thread running.....");
try {
wait();
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Resumed");
}
}
public void consume(){
Scanner sc=new Scanner(System.in);
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
e.printStackTrace();
}
synchronized (this){
System.out.println("Waiting for return key");
sc.nextLine();
System.out.println("Return key pressed");
notify();
System.out.println("Completed");
}
}
}

public class Q13 {
public static void main(String[] args) throws InterruptedException {
demo d1=new demo();
Thread t1=new Thread(new Runnable() {
public void run() {
d1.produce();
}
});
Thread t2=new Thread(new Runnable() {
public void run() {
d1.consume();
}
});
t1.start();
t2.start();
t1.join();
t2.join();
}
}