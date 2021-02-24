import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class thread1 implements Runnable{
String s;
public thread1(String str){
s=str;
}
public void run() {
for(int i=1;i<=5;i++){
System.out.println("Name:-" +s+"Value:-"+i);
try {
Thread.sleep(1000);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
System.out.println(s+"Completed");
}
}
public class Q9a {
public static void main(String[] args) {
Runnable t1=new thread1("Thread 1");
Runnable t2=new thread1("Thread 2");
Runnable t3=new thread1("Thread 3");
Runnable t4=new thread1("Thread 4");
ExecutorService es= Executors.newFixedThreadPool(2);
es.execute(t1);
es.execute(t2);
es.execute(t3);
es.execute(t4);
es.shutdown();
}
}