public class Q1 implements Runnable{
	public static void main(String[] args) {
		Thread t1 = new Thread(new Q1());
		t1.start();
	}
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
		}
	}

}