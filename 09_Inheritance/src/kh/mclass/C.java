package kh.mclass;

import java.util.List;
import java.util.Set;

//The type C cannot subclass the final class B
public class C {
	private int num1;
//	public void method1() {
//		System.out.println("method_"+1);
//	}
	private String str;
	public void method2() {
		
	}
	@Override
	public String toString() {
		return "C [num1=" + num1 + ", str=" + str + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
//	Cannot override the final method from A
//	@Override
	protected void method1() {
		System.out.println("C가 다시 재정의 함 method_"+1);
	}
}
