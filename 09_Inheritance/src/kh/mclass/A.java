package kh.mclass;

public class A {
	private int num1;

	/* final */ void method1() {
		System.out.println("method_" + 1);
	}

	@Override
	public String toString() {
		return "A [num1=" + num1 + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

}
