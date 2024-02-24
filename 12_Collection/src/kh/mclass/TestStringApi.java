package kh.mclass;

public class TestStringApi {
	public static void main(String[] args) {
		// String 미리 만들어둔 메소드(API)
		// 1. 기능에 맞는 이름찾기
		// 2. 매개인자 parameter argument 맞게 작성하기
		// 3. return 자료형 확인해서 변수에 담기
		String str1 = "hello World";
		String str2 = "hello world";
		String str3 = "헬로1 월드";

		char ch = str1.charAt(6); // 'W'
		System.out.println(ch);

		int compareInt = str1.compareTo(str2); // 메소드 쓸 때 리턴 자료형 먼저 보고 좌변 입력
		int compareInt2 = str2.compareTo(str1);
		int compareInt3 = str3.compareTo(str2);
		System.out.println(compareInt); // -32
		System.out.println(compareInt2); // 32
		System.out.println(compareInt3);

		System.out.println("hello wdaafdorld".compareTo("hello zasdfsdforld"));
		// 처음으로 다른 인덱스에서 비교하는 값
		System.out.println("a b c".concat("ABC" + "\n줄도\t바꿔지나"));

		System.out.println(str1.equals(str2));
		System.out.println(str1.equalsIgnoreCase(str2));

		System.out.println(str1.replace('l', 'a'));
		System.out.println(str1.replaceFirst("ll", "mom"));
		System.out.println(str1.replaceAll("[a-z]", "*")); // [a-z] <-- 요런게 regex(regular expression)
		System.out.println(str3.replaceAll("[0-9]", "*"));

		System.out.println(str1.substring(3));
		System.out.println(str1.substring(0, 3));

		System.out.println("===== split =====");

		String[] arrStr = str1.split("l");
//		for (int i = 0; i < arrStr.length; i++) {
//			System.out.print("[");
//			System.out.print(arrStr[i]);
//			System.out.print("]");
//		}
		for (String str : arrStr) {
			System.out.print("[");
			System.out.print(str);
			System.out.print("]");
		}

//		StringBuffer sb1 = "스트링버퍼값";
		StringBuffer sb1 = new StringBuffer("스트링버퍼값");
		String str10 = new String("스트링객체 만들어서 비교 == 안됨. equals 써야함");

		String immutable1 = "aaa";
		immutable1 = "bbb";

		sb1.append("기존 문자를 가변적으로 바꿀수 있기 때문에 추가하는 append 메소드가 제공됨.");
		// concat은 두 주소를 연결자로 묶음

	}
}
