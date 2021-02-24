import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
class demo{
ReentrantLock r=new ReentrantLock();
Condition con=r.newCondition();
public void funtion1(){
r.lock();
System.out.println("Funtion 1 invoked");
try {
con.await();
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Funtion 1 resumed");
r.unlock();
}
public void funtion2(){
r.lock();
System.out.println("Funtion 2 invoked");
try {
con.await();
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Funtion 2 resumed");
r.unlock();
}
public void funtion3(){
r.lock();
System.out.println("Funtion 3 invoked");
con.signalAll();

System.out.println("Signal all");
r.unlock();
}
}
public class Q15b {
public static void main(String[] args) {
demo d = new demo();
Thread t1=new Thread(new Runnable() {
public void run() {
d.funtion1();
}
});
Thread t2=new Thread(new Runnable() {
public void run() {
d.funtion2();
}
});
Thread t3=new Thread(new Runnable() {
public void run() {
d.funtion3();
}
});
t1.start();
t2.start();
try {
Thread.sleep(3000);
} catch (InterruptedException e) {
e.printStackTrace();
}
t3.start();
try {
t1.join();
t2.join();
t3.join();
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
