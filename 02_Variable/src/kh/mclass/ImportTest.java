package kh.mclass;

import java.util.Date;

public class ImportTest { /* ImportTest: identity 를 특정짓고 이름을 full 로 다 적음
							 이름은 짧을수록 속도가 빠름 but 구체화가 더 중요
							 type == class
							 다른 package 면 class 이름이 같아도 상관없음
							 class 이름: '_', '$' 통상적으로 쓰지 않음 
							 package 이름: 단어끼리는 '.'으로 구분지음 */
							//아래 파란색은 코드 말고 사용설명서 줄 때 사용
							/**이 위치에 주석 작성*/
							/**이 위치에 주석 작성
							 * 여러줄일때
							 * */
	static int field1;
	
	
	public static void main(String[] args) {
		
		System.out.println(field1);
		
		
//		자료형 = Type = class 명
//		기본자료형 == primitive type
//		boolean / byte short int long / float double / char --> 8개
//		참조자료형 == reference type
//		String --> 1개
//		java.util.Date today = new java.util.Date();
		Date t = new Date(); // new: 진짜 집
//		java.sql.Date t2 = new java.sql.Date(2024, 1, 31); 
		java.util.Date t3 = new java.util.Date(2024, 1, 31); // import 한 패키지도 풀네임 써도 됨
		
		float f1 = (float)31.231;

		double d1;
		d1 = 1 + 3.0; // 우변 자료형 통일 -> ~~~
		
		f1 = 1 + 2.0f; // 1 + 2.0 의 결과가 float 형으로 통일됨
		
		f1 = (float)d1; // f1 = d1f 같이 변수 뒤에 f 를 쓰는 건 안됨
//						   (자료형): 명시적 형변환 == 강제 형변환, 탈락(truncation)은 있음
		
		int t1 = 10*2 + 2; // int t1(방 만들기) ->  10*2 + 2(계산) -> 우변을 좌변에 대입
		
//		t1 = 1 + 3.0; // 1이 아니라 1 + 3.0 의 계산 값이 double 이라 좌변으로 못 들어감
		
		System.out.println(t3);
		
//		Date: 방 크기, today: 방 이름
//		TODO : 투두리스트(다음날 뭐할지 기록용?) 
		
		byte x = -128; // 2^8 == 256, byte: -128~127
		boolean boo = true;
//		int adf = x + boo; // boolean은 쉽게 형변환이 안됨
		int y = 63; // 2^32 == 2147483648, int: -2147483648~2147483647 (10자리)
//						2^64 --> -9,~~ ~ 9,~~~ (19자리)
//						char: 0~65535 (음수는 없음)
		int z = x + y;
//		double a = 2.111111111111111111111;
//		double a2 = 2111111111111111111111.11;
//		boolean a3 = true --> boolean 은 원래 true, false 만 넣는 게 원칙 (다른 언어에서도)
		char ch = 'y'; // 보라색(int, char, byte 등) --> 예약어 (약 50가지 암기), 자료형 앞에 쓰임
//		char 은 문자 1자
		String str1 = "ㅁㅇㄴㄹ " + "ㅇㄹㄴㅇㄴㅁㄹㅇ"; // String 은 문자 0자 이상,
												 // 우변 먼저 처리 후 좌변에 대입
		System.out.println(ch);
		System.out.println(str1);
		System.out.println(x);
		System.out.println(z);
		/* x에 3을 대입 */
		
		char ch10 = '가';
		System.out.println(ch10);
		System.out.println((int)ch10);
		int d10 = ch10; // 대입연산자 다른 자료형일 경우 형변환(자동)
//		                   자료형 다르면 임시공간 저장, 같으면 직접
		System.out.println(d10);
		
		System.out.println("안녕하세요");
		System.out.println(123);
		
		for(int i = 0; i<40; i++) {
			System.out.println((char)i); // ascii 코드에서 48: '0', 65: 'A', 97: 'a'
		}
		
		int zxc = 56;
		final int PO = zxc;
		System.out.println(PO);
		
	}

}
