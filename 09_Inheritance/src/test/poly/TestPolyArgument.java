package test.poly;

public class TestPolyArgument {
	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Chair());
		b.buy(new Light());
		b.buy(new Desk());
	}
}

class Furniture {
	private int price; // 제품가격

	public Furniture(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

class Light extends Furniture {
	public Light() {
		super(50); // 부모 클래스의 생성자 호출
		// Furniture에 기본 생성자 없어서 가격을 매겨줘야 생성 가능
	}

	@Override
	public String toString() {
		return "Light";
	}

	public void LightMethod() {
		System.out.println("배송 불가");
	}
}

class Chair extends Furniture {
	public Chair() {
		super(100); // 부모 클래스의 생성자 호출
					// Furniture에 기본 생성자 없어서 가격을 매겨줘야 생성 가능
	}

	@Override
	public String toString() {
		return "Chair";
	}

	public void ChairMethod() {
		System.out.println("배송");
	}
}

class Desk extends Furniture {
	public Desk() {
		super(200);
	}

	@Override
	public String toString() {
		return "Desk";
	}

	public void DeskMethod() {
		System.out.println("배송비 2원");
	}
}

class Buyer {
	private int money = 500;

	public void buy(Furniture f) { // Furniture f 에서 '다형성' 발생, 어떤 클래스에 기능을 넣을지 = 추상화(Overloading, Overriding, 다형성
									// 등)
		if (money < f.getPrice()) // 멤버변수 price를 protected, (default)로 변경
		{
			System.out.println("잔액부족!");
			return;
		}
		money -= f.getPrice();
		System.out.println(f + " 구매성공! 잔액: " + money + " 만원");

		if (f instanceof Desk) { // instanceof는 ==, != 와 같은 우선순위
			((Desk) f).DeskMethod();
		}
		if (f instanceof Chair) {
			((Chair) f).ChairMethod();
		}
		if (f instanceof Light) {
			((Light) f).LightMethod();
		}

		// 코드 대충 해놓는 것 = pseudo-code = 수도 코드
//		if(f가 chair) {
//			ChairMethod();
//		}
//		if(f가 chair) {
//			ChairMethod();
//		}

	}
}