import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class Q8b implements Runnable {
public void run() {
System.out.println("Vaishali Kaushik");
}
public static void main(String[] args) {
ScheduledExecutorService scheduler
= Executors.newSingleThreadScheduledExecutor();
Runnable task = new Q8b();
scheduler.scheduleAtFixedRate(task , 4 , 2 ,TimeUnit.SECONDS);
}
}
