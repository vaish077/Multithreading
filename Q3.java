import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Threadpools extends Thread {
	private int id;

	public Threadpools(int id) {
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

public class Q3 {
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(4);
		for (int i = 0; i < 7; i++) {
			Threadpools t1 = new Threadpools(i);
			executor.submit(t1);
		}
		executor.shutdown();
		System.out.println("ALL TASK SUBIMITTED");
		executor.awaitTermination(10, TimeUnit.SECONDS);
		System.out.println("ALL TASK COMPLETED");
		if(executor.isTerminated()) {
			System.out.println(true);
		}

	}

}