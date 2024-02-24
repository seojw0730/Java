package kh.mclass;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
	public static void main(String[] args) {
//		!!다양한 타입의 객체들을 다루는 메소드나 클래스의 타입을
//		!!미리 명시(선언할때)
//		해 줌으로써 컴파일 시 타입을 체크할 수 있도록 하고,
//		!!형변환을 하는 번거로움 없이 사용하게 해주는 것으로 배열이나 이후 배울 컬렉션 사용 시
//		!! 데이터 타입의 안정성을 높일 수 있다
//		Overloading 의 한계 극복. <-- 새로운 자료형에 대처하지 못함.
		List<Double> list = new ArrayList/* <String> */(); // <> <-- 이게 제너릭
//		List list = new ArrayList();
		list.add(1.0);
		list.add(0.3);

	}
}
