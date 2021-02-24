import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class callabletask implements Callable<String>{
	private int id;
	public callabletask(int id) {
		this.id =id;	
		}
	public String call() throws Exception {
		System.out.println("ID : "+id+" : started");
		Thread.sleep(1000);
		return "ended : "+id+" : ended";
	}
}
public class Q6{
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i =0 ; i<3 ; i++) {
			Future<String> future = executor.submit(new callabletask(i));
			System.out.println(future.get());
			System.out.println("Future Tasks Not Cancelled "+future.isCancelled());
			System.out.println("Tasks Is Done "+future.isDone());
		}
	}
}