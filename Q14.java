class demo1{
public void funtion1(){
synchronized (this){
System.out.println("Funtion 1 invoked");
try {

wait();
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Funtion 1 resumed");
}
}
public void funtion2(){
synchronized (this){
System.out.println("Funtion 2 invoked");
try {
wait();
} catch (InterruptedException e) {
e.printStackTrace();
}
System.out.println("Funtion 2 resumed");
}
}
public void funtion3(){
synchronized (this){
System.out.println("Funtion 3 invoked");
notifyAll();
System.out.println("Notified all");
}
}
}
public class Q14 {
public static void main(String[] args) {
demo1 d=new demo1();
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
