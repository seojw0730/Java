package kh.mclass.jdbc.view;

import java.util.Scanner;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		while (true) {
			boolean exit = false;
			System.out.println("메뉴를 고르세요");
			System.out.println("1. EMP 도메인");
			System.out.println("2. DEPT 도메인");
			System.out.println("3. SALGRADE 도메인");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				new EmpMenu().empMenu();
				break;
			case "2":
				new DeptMenu().deptMenu();
				break;
			case "3":
				new SalgradeMenu().salgradeMenu();
				break;
			default:
				exit = true;
				break;
			}
			if (exit)
				break;
		}
		System.out.println("프로그램 종료");
	}
}
