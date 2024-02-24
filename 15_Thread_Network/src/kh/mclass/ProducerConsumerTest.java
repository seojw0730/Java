package kh.mclass;

public class ProducerConsumerTest {
	public static void main(String[] args) {
//		같은 buffer 를 Producer과 Consumer에 줘야함
		Buffer buffer = new Buffer();
		Producer p = new Producer(buffer);
		Thread c = new Thread(new Consumer(buffer));
		
		p.start();
		c.start();
	}
}
