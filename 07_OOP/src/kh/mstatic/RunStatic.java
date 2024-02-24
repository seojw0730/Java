package kh.mstatic;

public class RunStatic {
	public static void mehotd1() {
		System.out.println("그냥 static 클래스 메소드");
	}
	public static void main(String[] args) {
		// 여기 main 첫머리에서 static에 값 확인 가능
		BankAccount.setAmount(300);
		System.out.println(BankAccount.getAmount());
		
		String owner;
		String cId;
		String password;

		System.out.println("반갑습니다.");
		System.out.println("성함과 주민번호를 주시면 계좌 개설해드립니다.");

		BankAccount jw = new BankAccount("jw", "id", "0001");
		System.out.println(jw.getAmount());
		BankAccount yi = new BankAccount("yi", "idd", "0011");
		System.out.println(yi.getAmount());
		BankAccount cw = new BankAccount("cw", "iddd", "0111");
		System.out.println(cw.getAmount());
		BankAccount cw2 = new BankAccount("cw2", "iddd", "0111");
		System.out.println(cw.getAmount());
		BankAccount cw3 = new BankAccount("cw3", "iddd", "0111");
		System.out.println(cw.getAmount());
		BankAccount cw4 = new BankAccount("cw4", "iddd", "0111");
		System.out.println(cw.getAmount());
		
		jw.deposit(1000);
		yi.deposit(50000);

		System.out.println(jw.getBalance());
		System.out.println(yi.getBalance());
		System.out.println(cw.getBalance());
	}
}
