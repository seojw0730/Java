package kh.mclass;

public class TestThread {
	public static void main(String[] args) {
		System.out.println("Main Thread 시작");

//		새 일꾼 만들기
		ThreadA ta = new ThreadA();
//		일꾼 ta가 run 부분을 실행함
		ta.start();
		ta.setPriority(10);
//		ta.method1(); <-- 이런식이 아님, main thread가 하는 일

		Thread tb = new Thread(new ThreadB());
		tb.start();
		tb.setPriority(1);

		System.out.println("Main Thread 종료");
	}
}
