package kh.mclass;

public class Member {
	private String name; // 멤버 변수 != 전역 변수
	private final int age = 100; // 멤버 변수 != 전역 변수
	private double score;
	private char gender;
	private Student studentIns;
	private int studentNum;
	private String surName;

	public Member() {
//		this.age = 100; // final 필드는 초기화 꼭 해라
	}

	public String getSurName() {
		return this.surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getStudentNum() {
		return this.studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public double getScore() {
		return this.score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public char getGender() {
		return this.gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Student getStudentIns() {
		return this.studentIns;
	}

	public void setStudentIns(Student studentIns) {
		this.studentIns = studentIns;
	}

	public String getName(/* 뭘 줘야 이름을 주는지 */) {
		return this.name; // 필드에 있는 변수 쓸때는 ' this. '를 쓰는게 정석
	}

	public int getAge(/* 뭘 줘야 나이를 주는지 */) {
		return age;
	}

	public void setName(String name) { // 갈색 --> 매개변수(지역변수), 파란색 --> ,
										// 지역변수 >>우선>> 멤버변수
		this.name = name; /* this: 필드에 있는 변수를 불러올 때? */
	}

	public long sum(int a, int b) { // Overloading 1번
		return (long) a + b;
	}

	public double sum(float a, float b) { // Overloading 2번
		return (float) a + b;
	}

//	public int sum(int a, int b) { // Overloading 3번 - 1번이랑 매개변수 type이 겹쳐서 안됨, return type은 상관없음
//		return a + b;
//	}

	public long sum(double a, int b, int c) {
		return (long) a + b + c;
	}

	public long sum(int b, double a, int c) {
		return (long) a + b + c;
	}
}
