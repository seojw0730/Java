package kh.mclass;

public class Student {
	// 학생 - 개념 = Object = class = Type
	protected String id;
	private String name;
	private String phone;
	private int age;
	private double attendance; // 출석률
	int abcDefG; // getAbcDefG <-- 게터 이름
//	int aBCDEFG; <-- 변수명 이렇게 지정하면 안됨(몇몇 프레임워크에서 충돌)
	
	// Getter / Setter 게터, 세터
	
	// 기준점: 메소드를 만들고 호출할 수 있는가

	public String getId() {
		return id;
	}

	public void setId(String id) {
		// 최소 5글자 이상, 영문자, 숫자, _, 최대 20자까지 <-- 구체화(Abstraction)
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAttendance() {
		return attendance;
	}

	public void setAttendance(double attendance) {
		this.attendance = attendance;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", phone=" + phone + ", age=" + age + ", attendance="
				+ attendance + ", abcDefG=" + abcDefG + "]";
	}

	void exam()
	{
		System.out.println("평가 잘 보세요");
		// ~~~~
		System.out.println("점수는");
	}
	
	void discount() {
		System.out.println("평가 잘 보세요");
		// ~~~~
		System.out.println("점수는");
	}
	
	void entrance() {
		System.out.println("입실");
		// ~~~~
		// attendance = 값 업데이트
		System.out.println("");
	}
	
}
