package kh.mclass;

public class ThreadB implements Runnable {

	@Override
	public void run() {
		System.out.println("여기 ThreadB가 독립적으로 하는 일");
		for (int su = 1; su < 10; su++) {
			for (int dan = 2; dan < 10; dan++) {
				System.out.println("*");
			}
			System.out.println();
		}
	}

}
