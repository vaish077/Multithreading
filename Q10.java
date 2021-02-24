public class Q10 {
int c = 0;
void increment(String name) {
c++;
}
public static void main(String[] args) {
Q10 q = new Q10();
q.fun();
}
public void fun() {
Thread t1 = new Thread(new Runnable() {
public void run() {
for (int i = 0 ; i<10 ; i++) {
increment(Thread.currentThread().getName());
}
}
});
t1.start();
Thread t2 = new Thread(new Runnable() {
public void run() {
for (int i = 0; i < 10;i++) {
increment(Thread.currentThread().getName());
}
}
});
t2.start();
try {
t1.join();
t2.join();
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println(c);
}
}