package inherit.run;

import inherit.sample.Person;
import inherit.sample.Professor;
import inherit.sample.Student;

public class TestAbstract {
	public static void main(String[] args) {
		Student s1 = new Student("자바");
		s1.out();

		Student s2 = new Student("자바", "서재원"); // 자바는 this에, 서재원은 Person에 넣어줌
		s2.out();

		Professor p1 = new Professor("컴공");
		p1.out();

		Professor p2 = new Professor("컴공", "이제이");
		p2.out();

		Person person = new Person() {

			@Override
			public void out() { // 메소드의 제대로된 정의가 필요
				System.out.println("abstract class일 경우, new () 하면 지금처럼 ");
			}
		};
		
		
		
	}
}
