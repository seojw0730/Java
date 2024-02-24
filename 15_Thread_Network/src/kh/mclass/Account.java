package kh.mclass;

public class Account {
	private static int balance; // 잔액

	public static int getBalance() {
		return balance;
	}

	public static void setBalance(int balance) {
		Account.balance = balance;
	}

	public void withDraw(int money) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 출금 메소드
//		synchronized (this) { // this <-- new Account()
			if (balance >= money) {
				System.out.println("출금: " + money);
				balance -= money;
			} else {
				System.out.println("잔액부족");
			}
//		}
	}
}
