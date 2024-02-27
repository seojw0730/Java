package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.dao.EmpDao2;
import kh.mclass.jdbc.model.vo.Emp2;

public class EmpController2 {
	private EmpDao2 dao = new EmpDao2();

	public List<Emp2> selectList() {
		return dao.selectList();
	}

	public int insert(Emp2 emp) {
		return dao.insert(emp);
	}

//	public int delete(int empno) {
//		return dao.delete()
//	}

}
