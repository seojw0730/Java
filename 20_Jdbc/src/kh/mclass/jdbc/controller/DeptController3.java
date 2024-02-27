package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.DeptService3;
import kh.mclass.jdbc.model.vo.Dept3;

public class DeptController3 {
	private DeptService3 service = new DeptService3();

	public List<Dept3> selectList() {
		return service.selectList();
	}

	public int insert(Dept3 vo) {
		return service.insert(vo);
	}

	public int delete(int deptno) {
		return service.delete(deptno);
	}
}
