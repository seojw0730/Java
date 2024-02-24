package inherit.sample;

public abstract class Person {
	private String name;

	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

	// 어떻게 인사할지는 각자에게 맡김
	// abstract는 메소드에 붙일 수 있음(생성자 X)
	public abstract void out(); // 메소드 선언만 임시적으로 한 상태
//	public abstract void out2();
//	public abstract void out3();

}