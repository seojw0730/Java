package kh.mclass;

public class OperatorTest {
	public static void main(String[] args) {
		int x = 1;
		System.out.println(x);
		
		x = x + 1;
		System.out.println(x);
		
		x++;
		System.out.println(x);
		
		++x;
		System.out.println(x);
		
		System.out.println(x++);
		System.out.println(++x);
		
		x += 1;
		System.out.println(x);
		
		x =+ 1; // x = + 1; 이랑 같음
		System.out.println(x);
	}
}
