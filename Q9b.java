import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class thread2 implements Runnable{
String s;
public thread2(String str){
s=str;
}
public void run() {
for(int i=1;i<=5;i++){
System.out.println("Name:- " +s+ "Value:- "+i);
try {
Thread.sleep(1000);
} catch (InterruptedException e) {
e.printStackTrace();
}
}
System.out.println(s+ "Completed");
}
}
public class Q9b {
public static void main(String[] args) {
Runnable t1=new thread2("Thread");
Runnable t2=new thread2("Thread");
Runnable t3=new thread2("Thread");
Runnable t4=new thread2("Thread");
ExecutorService es= Executors.newCachedThreadPool();
es.execute(t1);
es.execute(t2);
es.execute(t3);
es.execute(t4);
es.shutdown();
}
}
