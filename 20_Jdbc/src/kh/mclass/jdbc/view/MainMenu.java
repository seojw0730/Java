package kh.mclass.jdbc.view;

import java.util.Scanner;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);

	public void mainMenu() {
		while (true) {
			boolean exit = false;
			System.out.println("메뉴를 고르세요.");
			System.out.println("1. EMP 도메인");
			System.out.println("2. DEPT 도메인");
			System.out.println("3. SALGRADE 도메인");
			System.out.print("메뉴 번호: ");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				empMenu();
				break;
			case "2":
				deptMenu();
				break;
			case "3":
				salgradeMenu();
				break;
			default:
				exit = true;
				break;
			}
			if (exit) {
				break;
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

	public void empMenu() {
		new EmpMenu2().empMenu();
	}

	public void deptMenu() {
		new DeptMenu().deptMenu();
	}

	public void salgradeMenu() {
		new SalgradeMenu().salgradeMenu();
	}
}
