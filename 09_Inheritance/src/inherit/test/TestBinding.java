package inherit.test;

import inherit.sample.Child;
import inherit.sample.Parent;

public class TestBinding {
	public static void main(String[] args) {
		// Binding 바인딩 (동적바인딩, 정적바인딩)
		// 컴파일시에는 정적 바인딩,
		// 실행시에는 동적 바인딩
		Parent p = new Parent();
		p.display(); // Parent의 display() 호출
		System.out.println("=== 구분 ===");
		// Down Casting - 
		Parent bind = new Child(); // 선언 부분 꼭 확인 // Up Casting
		bind.display(); // Child의 Override된 display() 호출 or Parent의 display() 호출 <-- 이 코드만 봤을때는 모름
		((Child)bind).out(); // 자료형변환() 가 '.' 보다 우선순위 낮음 // Down Casting
		
		Child c = new Child();
//		Child error = new Parent(); <-- Child 모양의 일부가 빠져있어서 대입 못함
		
	}
}
