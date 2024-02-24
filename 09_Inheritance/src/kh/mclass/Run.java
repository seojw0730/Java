package kh.mclass;

public class Run {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		C c = new C();
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(a.equals(c)); // a 주소에 있는 값들 = c 주소에 있는 값들 ?
//		System.out.println(a == c); // a 주소 값 = c 주소 값 ?

		String str1 = "abc";
		String str2 = "abc";
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));

		String str3 = new String("abc");
		String str4 = new String("abc");
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		System.out.println(str3 == str4);
		System.out.println(str3.equals(str4));
		
		System.out.println(str3==str1);
		System.out.println(str3.equals(str1));
		
		System.out.println(str1.hashCode());
		str1 = "a";
		System.out.println(str1.hashCode());
		

	}
}
