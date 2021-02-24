import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Q8 {
public static void main(String[] args) {
ScheduledExecutorService s=
Executors.newSingleThreadScheduledExecutor();

Runnable task=new Runnable() {

public void run() {
System.out.println("Hello");
}
};
s.schedule(task,5, TimeUnit.SECONDS);
s.shutdown();
}
}