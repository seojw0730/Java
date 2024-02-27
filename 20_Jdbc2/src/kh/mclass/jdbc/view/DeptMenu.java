package kh.mclass.jdbc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.DeptController;
import kh.mclass.jdbc.model.vo.Dept;

public class DeptMenu {
	private Scanner sc = new Scanner(System.in);
	private DeptController controller = new DeptController();

	public void deptMenu() {
		while (true) {
			boolean exit = false;
			System.out.println("메뉴를 고르세요");
			System.out.println("1. DEPT 조회");
			System.out.println("2. DEPT 추가");
			System.out.println("3. DEPT 삭제");
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
		List<Dept> list = controller.selectList();
		if (list == null)
			System.out.println("오류로 데이터 읽기 실패");
		else {
			System.out.println("부서 수: " + list.size());
			if (list.size() > 0) {
				for (Dept vo : list) {
					System.out.println(vo);
				}
			}
		}
	}

	public void insert() {
		try {
			System.out.print("deptno: ");
			String deptnoStr = sc.nextLine();
			int deptno = Integer.parseInt(deptnoStr);
			System.out.print("dname: ");
			String dname = sc.nextLine();
			System.out.print("loc: ");
			String loc = sc.nextLine();
			System.out.print("mgr: ");

			Dept vo = new Dept(deptno, dname, loc);

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
			System.out.print("삭제할 deptno: ");
			String deptnoStr = sc.nextLine();
			int deptno = Integer.parseInt(deptnoStr);

			int result = controller.delete(deptno);

			if (result > 0)
				System.out.println("삭제 성공");
			else
				System.out.println("삭제 실패");
		} catch (NumberFormatException e) {
			System.out.println("다시 입력");
		}
	}
}
