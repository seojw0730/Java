package kh.mclass;

public class ThreadA extends Thread {

	@Override
	public void run() {
		System.out.println("여기 ThreadA가 독립적으로 하는 일");
		for (int dan = 2; dan < 10; dan++) {
			for (int su = 1; su < 10; su++) {
				System.out.printf("%d * %d = %d\n", dan, su, dan * su);
//				try {
//					Thread.sleep(5);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
			System.out.println("============");
		}
//		List<String> list = new ArrayList<String>(); 등등
	}

	public void method1() {
		System.out.println("ThreadA - method1()");
	}
}
