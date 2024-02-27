package kh.mclass.jdbc.view;

import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.DeptController3;
import kh.mclass.jdbc.model.vo.Dept3;

public class DeptMenu3 {
	private Scanner sc = new Scanner(System.in);
	private DeptController3 controller = new DeptController3();

	public void deptMenu() {
		while (true) {
			boolean exit = false;
			System.out.print("메뉴를 고르세요");
			System.out.print("1. DEPT 조회");
			System.out.print("2. DEPT 추가");
			System.out.print("3. DEPT 삭제");
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
	}

	public void selectList() {
		List<Dept3> list = controller.selectList();
		if (list == null) {
			System.out.println("오류로 데이터 읽기 실패");
		} else {
			System.out.println("사원 수: " + list.size());
			if (list.size() > 0) {
				for (Dept3 vo : list) {
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

			Dept3 vo = new Dept3(deptno, dname, loc);
			int result = controller.insert(vo);
			if (result > 0) {
				System.out.println("추가 성공");
			} else {
				System.out.println("추가 실패");
			}
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
			if (result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (NumberFormatException e) {
			System.out.println("다시 입력");
		}
	}
}
