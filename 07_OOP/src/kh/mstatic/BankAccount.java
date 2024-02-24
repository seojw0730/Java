package kh.mstatic;

public class BankAccount {
	private static int amount = 5; // 클래스변수(클래스당 하나밖에 없음) 클래스변수⊂⊂멤버변수
	private String no; // 멤버변수
	private String password;
	private String owner;
	private String cId;
	private int balance;

	public static int getAmount() {
		return amount;
	}

	public static void setAmount(int amount) { // amount 못 바꾸게 함 -> 요구사항 정의서 필요 이유
		BankAccount.amount = amount;
	}

	// public BankAccount() {} // <-- 기본 생성자는 생략 가능
	public BankAccount(String owner, String cId, String password, String no) { // <-- 제한 있는 생성자
		this.owner = owner;
		this.cId = cId;
		this.password = password;
		this.no = no;
		if (this.amount == 0) {
			System.out.println("선착순 마감");
			return;
		}
	}

	public BankAccount(String owner, String cId, String password) { // <-- 제한 있는 생성자
		this.owner = owner;
		this.cId = cId;
		this.password = password;
		if (this.amount == 0) {
			System.out.println("선착순 마감");
			return;
		}
		this.amount--;
		this.no = "";
		System.out.println(Math.random());
		double randomNo = Math.random();
		String randomStr = String.valueOf(randomNo);
		System.out.println(randomStr);
		System.out.println(randomStr.substring(2));
		this.no = randomStr.substring(2);
	}

	public String getNo() {
		return no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOwner() {
		return owner;
	}

	public String getcId() {
		return cId;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int input) {
		balance += input;
	}

	public void withdraw(int output, String inputPass) {
		if (!this.checkPassword(inputPass)) {
			System.out.println("비밀번호가 틀립니다. 다시 확인하세요.");
			return;
		}
		if (balance < output) {
			System.out.println("잔액부족");
			return;
		}
		balance -= output;
	}

	public boolean checkPassword(String inputPassword) {
		if (inputPassword.equals(this.password)) {
			return true;
		} else {
			return false;
		}
	}
}