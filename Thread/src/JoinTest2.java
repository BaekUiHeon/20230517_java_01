class MyThread1 extends Thread{
	public void run() {
		for(int i=0;i<1000;i++) {
			System.out.println(getName());
			Thread.yield();
		}
	}
}

public class JoinTest2 {

	public static void main(String[] args) {
		

	}

}
