package inherit.sample;

public class Child extends Parent {
	private int num = 2;

	public Child() {
		this(10);
	}

	public Child(int a) {
		super();
//		setNum(a);
	}

	int count = 1;

	public void out() {
		System.out.println("자식 클래스 메소드");

	}

	@Override
	public void display() {
//		if (count > 5) {
//			return; // 이런 조건 없으면 eclipse 죽음
//		}
//		count++;
		System.out.println("안녕하세요. 인사드립니다.");
		System.out.println("num : " + num);
		System.out.println("super.num : " + super.num);
		super.display();
	}
}
