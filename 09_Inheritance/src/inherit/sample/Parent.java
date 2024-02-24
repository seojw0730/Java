package inherit.sample;

public class Parent {
	protected int num = 1;

	public Parent() {
		super();
	}

	public void display() {
		System.out.println("부모 클래스 메소드");
	}

	public int getNum() {
		return num;
	}

	protected void setNum(int num) {
		this.num = num;
	}

}
