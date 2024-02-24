package kh.mclass;

public final class B {
	private int num1;
	private String str;

	public void method1() {
		System.out.println("method1");
	}
	public void method2() {
		System.out.println("method2");
	}
	@Override
	public String toString() {
		return "B [num1=" + num1 + ", str=" + str + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
}
