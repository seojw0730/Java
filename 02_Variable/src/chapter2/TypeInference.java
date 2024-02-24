package chapter2;

public class TypeInference {

	public static void main(String[] args) {
		var i = 10; // int 로 컴파일
		var j = 10.0; // double 로 컴파일
		var str = "hello"; // String 으로 컴파일
		
		System.out.println(i);
		System.out.println(j);
		System.out.println(str);
		
		str = "test";
		
		System.out.println(str);
	}

}
