package kh.mclass;

public class SyncChangeNumber extends Thread {
	private SharedData sdata;

	public SyncChangeNumber(SharedData sdata) {
		this.sdata = sdata;
	}

	@Override
	public void run() {
		for (int k = 1; k <= 5; k++) {
			sdata.calcNumber();

			// 해당 스래드가 공유자원 사용이 끝난 상태라면
			if (this.getState() == Thread.State.TERMINATED) {
				// 다른 스래드한테 신호를 보냄
				System.out.println("***TERMINATED***");
				this.notify();
			}
		}
	}
}
