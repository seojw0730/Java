package inherit.sample;

import kh.mclass.B;

public class Student extends Person implements InterfaceSample {
	// 순서: 멤버변수 - 기본생성자 - 매개변수 생성자 - getter/setter - toString - override
	// 강사님 순서: 멤버변수 - 기본생성자 - 매개변수 생성자 - toString - getter/setter - override
	private String subject;

	public Student() {
	}

	public Student(String subject) {
		super();
		this.subject = subject;
	}

	public Student(String subject, String name) {
		super(name);
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [subject=" + subject + "]";
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public void out() {
		System.out.println("저는 " + super.getName() + "학생입니다.");
		System.out.println(subject + " 수강하고 있습니다.");
	}

	@Override
	public void method1(B b) {
		// TODO Auto-generated method stub

	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method3() {
		// TODO Auto-generated method stub

	}

	@Override
	public void method4() {
		// TODO Auto-generated method stub

	}

	@Override
	public String testSum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sumTest() {
		// TODO Auto-generated method stub
		return null;
	}

}
