package kh.mclass;

import java.util.*;
import java.util.Map.Entry;

public class TestCollection {
	public static void main(String[] args) {
		List<String> strList = new LinkedList<String>();
		strList.add("A");
		strList.add("d");
		strList.add("z");
		strList.add("X");
		strList.add("E");
		strList.add("F");
		strList.add("!!#@$!");
		System.out.println(strList.get(2));
		System.out.println(strList);
		System.out.println(strList.remove(2));
		System.out.println(strList);
		System.out.println(strList.isEmpty());
//		strList.clear();
//		System.out.println(strList);
//		System.out.println(strList.isEmpty());

		System.out.println("=== 정렬전 ===");
		System.out.println(strList);

		System.out.println("===========");
//		System.out.println(strList.sort(null));

		System.out.println("=== 정렬후 ===");
		Collections.sort(strList);
		System.out.println(strList);

		System.out.println("=== Set(중복X, index순서X) + Map 함께 ===");

		Set<String> s1 = new HashSet<String>();
		s1.add("oracle");
		s1.add("java");
		s1.add("html");

//		사용불가
//		for (int i = 0; i < s1.size(); i++) {
//			System.out.println(s1.iterator());
//		}

		for (String a : s1) { // enhanced for를 써야 하나씩 꺼내기 가능
			System.out.println(a);
//			switch(a) {
//			case "java":
//				break;
//			}
		}

		HashSet<String> strHash = new HashSet<String>();
		strHash.add("1");
		strHash.add("5");
		strHash.add("3");
		strHash.add("4");
		strHash.add("2");
		System.out.println(strHash);

		TreeSet<String> strTree = new TreeSet<String>();
		strTree.add("1");
		strTree.add("ad");
		strTree.add("가");
		strTree.add("5");
		System.out.println(strTree);

		LinkedHashSet<String> strLinked = new LinkedHashSet<String>();
		strLinked.add("1!");
		strLinked.add("!@$@");
		System.out.println(strLinked);

		System.out.println("=== Map(key, value) 1. key는 Set형태 + String ===");
		Map<String, Integer> m1 = new HashMap<String, Integer>();
		m1.put("가", 0);
		m1.put("가", 3);
		m1.put("나", 1);
		m1.put("다", 2);
		int v1 = m1.get("가");
		System.out.println(m1);
		System.out.println(m1.size());

		Set<String> m1KeySet = m1.keySet();

		for (String e : m1KeySet) {
			System.out.print(e + ",");
			System.out.println(m1.get(e));
		}

//		"banana", "lemon", "potato" 추가하고
//		2번째 추가한 것을 삭제하고
//		결과를 모두 display 해주세요

		List<String> foodList = new ArrayList<String>();
		foodList.add("banana"); // 등록
		foodList.add("lemon"); // 등록
		foodList.add("potato"); // 등록
		for (String food : foodList) { // Menu 4.출력
			System.out.print(food + "; ");
		}
		foodList.set(1, "blueLemon");

		System.out.println();
		System.out.println(foodList.get(1));

//		foodList.remove(1);
		for (String food : foodList) {
			System.out.print(food);
		}
		System.out.println("===========");

		Iterator<String> foodIterator = foodList.iterator();
		System.out.println(foodIterator);
		// 클래스풀네임 $ 내부클래스 @ hashcode
		// 형변환 - 자동, 강제 - 내부클래스 메소드 쓰고 싶어서 형변환
		while (foodIterator.hasNext()) {
			String food = foodIterator.next();
			System.out.print(food);
		}

		Map<String, String> foodMap = new HashMap<String, String>();
		System.out.println("새상품등록");
		foodMap.put("b-1", "banana");
		System.out.println("새상품등록");
		foodMap.put("b-2", "lemon");
		System.out.println("새상품등록");
		foodMap.put("a-1", "potato");
		System.out.println("새상품등록");
		foodMap.put("a-2", "banana");

		System.out.println(foodMap);
		Set<String> foodKeySet = foodMap.keySet();
		for (String food : foodKeySet) {
			System.out.println(food + " - " + foodMap.get(food));
		}

		foodMap.replace("b-2", "lemon 재고 없음");
		System.out.println(foodMap);
		foodMap.remove("b-2");
		System.out.println(foodMap/* .toString() 이 보이지 않게 붙음 */);

//		조회
		System.out.println("상품목록조회");

		Iterator<String> a = foodMap.keySet().iterator();
		while (a.hasNext()) {
			String key = a.next();
			System.out.println(key);
		}

		System.out.println("=== entry ===");
		System.out.println(foodList.toString());
		System.out.println(foodMap.toString());

		System.out.println("=== 여러 컬렉션 복합자료형 ===");

		// 가장 대표 자료형 - 바깥쪽 할당
		List<Map<String, Student>> list = new ArrayList<Map<String, Student>>();
		// lm 자료형 = List -> List 메소드 제공
		// List 공간만 생성된 상태 -> List[null]
		System.out.println(list);
		// 가장 내부에 있는 참조형 new
		// 안쪽 - 할당
		Map<String, Student> map = new HashMap<String, Student>();
		// 최종 내부 - 할당
		Student instance = new Student();
		System.out.println(list);

		// 최종 내부 - 값 채우기
		instance.setId("abc");
		instance.setId("홍길동");
		System.out.println(list);

		// 바깥 - 값 채우기
		map.put("1", instance);
		System.out.println(list);

		// 가장 바깥 - 값 채우기
		list.add(map);
		System.out.println(list.get(0));

		Map<String, List<Student>> map2_1학년 = new HashMap<String, List<Student>>();
		List<Student> list2_1반 = new ArrayList<Student>();

		Student instance2 = new Student();
		instance2.setId("1번");
		instance2.setAge(111);
		instance2.setName("호잉");
		list2_1반.add(instance2);

		Student instance3 = new Student();
		instance3.setId("2번");
		list2_1반.add(instance3);

		Student instance4 = new Student();
		instance4.setId("3번");
		list2_1반.add(instance4);

		map2_1학년.put("1학년", list2_1반);

		System.out.println("<");
		System.out.println(map2_1학년);
		System.out.println(">");

		Map<String, Object> comp1_3 = new HashMap<String, Object>();
		comp1_3.put("1-1", 123);
		comp1_3.put("1-2", "ㅇㄴ");
		comp1_3.put("1-3", instance);
		comp1_3.put("1-4", v1);
		// {1-1=123, 1-2=ㅇㄴ, 1-3=Student [id=홍길동, name=null, phone=null, age=0,
		// attendance=0.0, abcDefG=0], 1-4=3}
		System.out.println(comp1_3);

		Set<Entry<String, String>> es = foodMap.entrySet();
		System.out.println(es);

//		상품코드만 담을 Set 만들기
//		foodKeySet = foodMap.keySet();
//		System.out.println(foodMap.keySet());

//		key들 개수만큼 반복하면 모든 상품정보를 볼 수 있음
		for (String food : foodKeySet) { // hasMoreNext(); 기능 포함
			System.out.println(food + " - " + foodMap.get(food));
		}
	}
}