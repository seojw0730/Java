package member.model.vo;

import java.util.Date;

public class Member {
	private String name;
	private int age;
	private Date enrollDate;
	String str = "기차" + 123 + 45 + "출발";
	
	public Member() {
		System.out.println(str);
	} // 생성자 메소드
	
	public Member(String name, int age, Date enrollDate) { // 생성자 메소드
		super();
		this.name = name;
		this.age = age;
		this.enrollDate = enrollDate;
	}
	
	public String getName() { // 멤버 메소드
		return name;
	}
	
	public void setName(String name) { // 멤버 메소드
		this.name = name;
	}
}
