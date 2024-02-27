package kh.mclass.jdbc.view;

import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.SalgradeController;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeMenu {
	private Scanner sc = new Scanner(System.in);
	private SalgradeController controller = new SalgradeController();

	public void salgradeMenu() {
		while (true) {
			boolean exit = false;
			System.out.println("메뉴를 고르세요");
			System.out.println("1. SALGRADE 조회");
			System.out.println("2. SALGRADE 추가");
			System.out.println("3. SALGRADE 삭제");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				selectList();
				break;
			case "2":
				insert();
				break;
			case "3":
				delete();
				break;
			default:
				exit = true;
				break;
			}
			if (exit)
				break;
		}
		System.out.println("메인으로");
	}

	public void selectList() {
		List<Salgrade> list = controller.selectList();
		if (list == null)
			System.out.println("오류로 데이터 읽기 실패");
		else {
			System.out.println("급여 수: " + list.size());
			if (list.size() > 0) {
				for (Salgrade vo : list) {
					System.out.println(vo);
				}
			}
		}
	}

	public void insert() {
		try {
			System.out.print("grade: ");
			String gradeStr = sc.nextLine();
			int grade = Integer.parseInt(gradeStr);
			System.out.print("losal: ");
			String losalStr = sc.nextLine();
			int losal = Integer.parseInt(losalStr);
			System.out.print("hisal: ");
			String hisalStr = sc.nextLine();
			int hisal = Integer.parseInt(hisalStr);

			Salgrade vo = new Salgrade(grade, losal, hisal);

			int result = controller.insert(vo);
			if (result > 0)
				System.out.println("추가 성공");
			else
				System.out.println("추가 실패");
		} catch (NumberFormatException e) {
			System.out.println("다시 입력");
		}
	}

	public void delete() {
		try {
			System.out.print("삭제할 grade: ");
			String gradeStr = sc.nextLine();
			int grade = Integer.parseInt(gradeStr);

			int result = controller.delete(grade);

			if (result > 0)
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");
		} catch (NumberFormatException e) {
			System.out.println("다시 입력");
		}
	}
}
