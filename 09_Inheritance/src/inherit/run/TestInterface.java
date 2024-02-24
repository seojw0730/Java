package inherit.run;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestInterface {
	public static void main(String[] args) {
		// int[] arr = new int[4]; 꼴
		List<Integer> intList = new ArrayList<Integer>(); // 많이 사용
		List<String> strList = new LinkedList<String>();
		List<String> strList2 = new ArrayList<String>(); // 많이 사용, ArrayList의 고유한 메소드 쓸거 아니면
														 // List로 선언해라

		intList.add(3);
		intList.add(4);
		intList.add(6);
		System.out.println(intList.size());
		intList.add(8);
		intList.add(9);
		System.out.println(intList.size());
		intList.remove(2);
		System.out.println(intList.size());
		System.out.println(intList);

		strList.add("홍길동");
		strList.add("홍길");
		strList.add("홍");
		strList.add("홍길");
		strList.add("홍길동");
		System.out.println(strList);
		strList.remove(2);
		System.out.println(strList);
	}
}
