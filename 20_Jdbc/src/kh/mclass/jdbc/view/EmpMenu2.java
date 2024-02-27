package kh.mclass.jdbc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.DeptController;
import kh.mclass.jdbc.controller.EmpController2;
import kh.mclass.jdbc.model.vo.Dept;
import kh.mclass.jdbc.model.vo.Emp2;

public class EmpMenu2 {
	private Scanner sc = new Scanner(System.in);
	private EmpController2 controller = new EmpController2();

	public void empMenu() {
		while (true) {
			boolean exit = false;
			System.out.println("메뉴를 고르세요.");
			System.out.println("1. EMP 조회");
			System.out.println("2. EMP 추가");
			System.out.println("3. EMP 삭제");
			String menu = sc.nextLine();
			switch (menu) {
			case "1":
				selectList();
				break;
			case "2":
				insert();
				break;
//			case "3":
//				delete();
//				break;
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

	public void selectList() {
		List<Emp2> list = controller.selectList();
		if (list == null) {
			System.out.println("오류로 데이터 읽기 실패");
		} else {
			System.out.println("사원 수: " + list.size());
			if (list.size() > 0) {
				for (Emp2 emp : list) {
					System.out.println(emp);
				}
			}
		}
	}

	public void insert() {
		try {
			System.out.print("empno(4자리숫자 1001~9999 중 고유값으로): ");
			String empnoStr = sc.nextLine();
			int empno = Integer.parseInt(empnoStr);
			System.out.print("ename: ");
			String ename = sc.nextLine();
			System.out.print("job: ");
			String job = sc.nextLine();
			System.out.print("mgr(7369, 7499, ... 원래 사원 번호만): ");
			String mgrStr = sc.nextLine();
			int mgr = Integer.parseInt(mgrStr);
			System.out.print("sal(5자리.00): ");
			String salStr = sc.nextLine();
			double sal = Double.parseDouble(salStr);
			System.out.print("comm(5자리.00): ");
			String commStr = sc.nextLine();
			double comm = Double.parseDouble(commStr);
			System.out.print("deptno(10, 20, 30, 40): ");
			String deptnoStr = sc.nextLine();
			int deptno = Integer.parseInt(deptnoStr);

			Date hiredate = null;

			Emp2 emp = new Emp2(empno, ename, job, mgr, hiredate, sal, comm, deptno);
			System.out.println("controller에 전달");
			controller.insert(emp);
		} catch (NumberFormatException e) {
			System.out.println("자료 형태에 맞게 입력해주세요.");
		}
	}

//	public void delete() {
//		controller.delete();
//	}
}
