package kh.mclass;

public class TestSynchronized {
	public static void main(String[] args) {
//		Thread t1 = new AccountManager("ATM");
//		Thread t2 = new AccountManager("인터넷뱅킹");
//		Thread t3 = new AccountManager("모바일앱");
//		t1.start();
//		t2.start();
//		t3.start();
		
		SharedData shareObj = new SharedData();
		
		SyncReadNumber t1 = new SyncReadNumber(shareObj);
		t1.getState();
		SyncChangeNumber t2 = new SyncChangeNumber(shareObj);
		t1.start();
		t2.start();
		t2.getState();
	}
}