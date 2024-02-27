package kh.mclass.jdbc.view;

import java.util.Scanner;

public class MainMenu2 {
	private Scanner sc = new Scanner(System.in);

	public void mainMenu2() {
		while (true) {
			boolean exit = false;
			System.out.println("메뉴를 고르세요");
			System.out.println("1. EMP 도메인");
			System.out.println("2. DEPT 도메인");
			String menu = sc.nextLine();
			switch (menu) {
			case "2":
				deptMenu();
				break;
			}
		}
	}

	public void deptMenu() {
		new DeptMenu2().deptMenu();
	}
}
