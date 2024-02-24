package kh.mclass;

class Point {
	int x, y;
}

class ChildPoint extends Point {
}

class Triangle<T extends Point> {
	T pos1, pos2, pos3;
}

class GenericChildEx<T extends Point> { // 상위클래스 제한
	T pos1, pos2, pos3;
}

//class GenericChildEx2<T super Point> { // 하위클래스 제한
//	T pos1, pos2, pos3;
//}

public class GenericEx<T, S> {
//	<T> 를 <T, V, E, S>로 쓰면 생성자 자료형도 4가지 써야함
	public T a1;

	public T getA1() {
		return a1;
	}

	public void setA1(T a1) {
		this.a1 = a1;
	}

	public <K> K methodGeneric(K a2) {
		return a2;
	}

//	public <S> S method2Generic(Object[] a2,<? super Point> index/* , S a3 */) {
////		자료형 -> 매개인자로 써야 메소드 사용시 가이드가 맞게 나옴
//		return (S) a2[index];
//	}

	public static void main(String[] args) {
		GenericEx<String, Integer> ex1 = new GenericEx();
		ex1.setA1("a1");

		GenericEx<Integer, Double> ex2 = new GenericEx();
		ex2.setA1(2);

		String r1 = ex1.methodGeneric("123");
		Integer r2 = ex1.methodGeneric(2);
		Student r3 = ex1.methodGeneric(new Student());

//		Integer obj = ex2.method2Generic(Integer[] {1}, 3.0/* , 5 */);

		Triangle<Point> ex3 = new Triangle();
	}
}