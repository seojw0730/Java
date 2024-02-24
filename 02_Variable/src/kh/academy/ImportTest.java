package kh.academy;

import java.sql.Date;
//import java.lang.System;
//	기본 패키지

public class ImportTest {
//	ImportTest
//	void method3();
//	선언만 한 것
	
	public static void method1(){
		java.util.Date date1;
		Date date2;
//		void ~~~: 해줘
		System.out.println("안녕하세요");
//		메소드 호출. 아래의 method1(); 와 같은 형태
		double result  = methodSum(3, 5);
		System.out.println(result);
		return;
//		return; 은 적지 않는 게 일반적 but void까지 없앨 순 없음
	}
	
	public static double methodSum(int a, int b) {
		main(null);
//		1. a = 1;
//		2. b = 3;
//		3. return 4L;
		return (double)a + b;
	}
	
	public static void main(String[] args) {
//		(매개변수 선언) {메소드 정의 선언} 호출은 main에서
//		Run을 하면 처음에 main(null)을 한번은 호출
		method1();
		double result = methodSum(10, (byte)20);
//		result 방 만들기 -> 매개변수 차례로 함수에 들어가서 기능 수행
		double c = methodSum(1, (byte)2);
		System.out.println(c);
		System.out.println(result);
		
		result = methodSum(212222341, 432421323);
//		1. a = 212222341;
//		2. b = 432421323;
		System.out.println(result);
//		void == 정해지지 않은 자료형: 값 자체가 존재하지 않는 자료형
	}

}
