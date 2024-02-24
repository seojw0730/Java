package kh.mclass;

import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.*;

public class Run {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("현재시간 : " + date);
//		Calendar c = new Calendar();
		Scanner sc = new Scanner(System.in);
		while (true) {
			String inputStr = sc.nextLine();
			if (inputStr.equals("퇴근")) { // String 비교는 equals로 해야함
				break;
			}
			System.out.println("이름이?");
			String inputName = sc.nextLine();
			System.out.println("아이디?");
			String inputId = sc.nextLine();

			Student jw = new Student();
//			jw.name = inputName;
			jw.setName(inputName);
//			jw.id = inputId;
			jw.setId(inputId);

			System.out.println("이름이?");
			String inputName2 = sc.nextLine();
			System.out.println("아이디?");
			String inputId2 = sc.nextLine();

			Student ej = new Student();
//			ej.name = inputName; // 필드 대입
			ej.setName(inputName2); // Setter를 사용
//			ej.id = inputId2;
			ej.setId(inputId2);
		}
		
		Member m1 = new Member();
		m1.sum(1.0f, 2.3f);
		m1.sum(3, 5);
	}
}
