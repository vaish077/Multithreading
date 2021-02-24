import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Q7 extends Thread{
	private int id;
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i = 0; i< 5; i++) { 
			executor.submit(new Q7(i));
		}
		System.out.println("ALL TASK SUBMITTED");
		executor.awaitTermination(10,TimeUnit.SECONDS); 
		System.out.println("ALL TASK COMPLETED");
	}
	public Q7(int id) {
		this.id = id;
	}
	public void run() {
		System.out.println(id + " : started");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(id + " : ended");	
	}
}