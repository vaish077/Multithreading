import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class demo {
int c = 0;
ReentrantLock lock = new ReentrantLock();
Condition con = lock.newCondition();
void fun1(){
lock.lock();
System.out.println("fun1 invoked");
System.out.println("Waiting");
try {
con.await();
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Woke up!!");
lock.unlock();
}
void fun2(){
lock.lock();
try {
Thread.sleep(2000);
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("fun2 invoked");
System.out.println("Signal invoke");
con.signal();
System.out.println("Fun2 completed");
lock.unlock();
}
}
public class Q15a {
public static void main(String[] args) {
demo q = new demo();
Thread t1=new Thread(new Runnable() {
public void run() {
q.fun1();
}
});
Thread t2=new Thread(new Runnable() {
public void run() {
q.fun2();
}
});
t1.start();
t2.start();
try {
t1.join();
t2.join();
} catch (InterruptedException e) {
e.printStackTrace();
}
}
}
