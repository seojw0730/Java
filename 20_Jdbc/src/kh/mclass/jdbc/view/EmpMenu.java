package kh.mclass.jdbc.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import kh.mclass.jdbc.controller.EmpController;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpMenu {
	private Scanner sc = new Scanner(System.in);
	private EmpController controller = new EmpController();

	public void empMenu() {
		while (true) {
			boolean exit = false;
			System.out.println("메뉴를 고르세요");
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
		List<Emp> list = controller.selectList();
		if (list == null) {
			System.out.println("오류로 데이터 읽기 실패");
		} else {
			System.out.println("사원 수: " + list.size());
			if (list.size() > 0) {
				for (Emp vo : list) {
					System.out.println(vo);
				}
			}
		}
	}

	public void insert() {
		try {
			System.out.print("empno: ");
			String empnoStr = sc.nextLine();
			int empno = Integer.parseInt(empnoStr);
			System.out.print("ename: ");
			String ename = sc.nextLine();
			System.out.print("job: ");
			String job = sc.nextLine();
			System.out.print("mgr: ");
			String mgrStr = sc.nextLine();
			int mgr = Integer.parseInt(mgrStr);
			System.out.print("sal: ");
			String salStr = sc.nextLine();
			double sal = Double.parseDouble(salStr);
			System.out.print("comm: ");
			String commStr = sc.nextLine();
			double comm = Double.parseDouble(commStr);
			System.out.print("deptno: ");
			String deptnoStr = sc.nextLine();
			int deptno = Integer.parseInt(deptnoStr);

			Date hiredate = null;

			Emp vo = new Emp(empno, ename, job, mgr, hiredate, sal, comm, deptno);

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
			System.out.print("삭제할 empno: ");
			String empnoStr = sc.nextLine();
			int empno = Integer.parseInt(empnoStr);

			int result = controller.delete(empno);
			if (result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
		} catch (NumberFormatException e) {
			System.out.println("다시 입력");
		}
	}

//	private int empno;
//	private String ename;
//	private String job;
//	private int mgr;
//	private Date hiredate;
//	private double sal;
//	private double comm;
//	private int deptno;
}
