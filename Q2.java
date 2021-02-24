public class Q2 extends Thread {
	static int count = 0;
	public static void main(String[] args) {
	Q2 t1 = new Q2();
	Q2 t2 = new Q2();	
	t1.start();
	t2.start();
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	}
	
	public void run() {
		for(int i=0;i<10;i++ ) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count++;
		}
		System.out.println(count);
	}

}