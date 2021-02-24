import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
class Threadpool extends Thread {
	private int id;
	public Threadpool(int id) {
		this.id = id;
	}
	public void run() {
		System.out.println("ID : " + id + " : STARTED");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("ID : " + id + " : END");
	}
}
public class Q5 {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 7; i++) {
			Threadpool t1 = new Threadpool(i);
			executor.submit(t1);
		}
		System.out.println("ALL TASK SUBIMITTED");
			if(executor.isShutdown()) {
				System.out.println(true);
			}
			else {
				System.out.println(false +" Tasks not completed yet");
			}
		executor.awaitTermination(10,TimeUnit.SECONDS);	
		if(!executor.isTerminated()) {
			System.out.println(true + "All tasks completed and termianted");
		}
		else {
			System.out.println(false +" All tasks not completed and terminated");
		}
		System.out.println("ALL TASK COMPLETED");
	}
}