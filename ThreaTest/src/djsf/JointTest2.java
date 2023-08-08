package djsf;

public class JointTest2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1= new MyThread1(); t1.start();
		Thread t2= new MyThread1(); t2.start();
		t1.join(); t2.join();
		System.out.println("main");
	}
}
class MyThread1 extends Thread{
	public void run() {
	for(int i=0;i<1000;i++) {
		System.out.println(getName());
		Thread.yield();
	}
}
}
