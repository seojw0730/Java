package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.DeptService2;
import kh.mclass.jdbc.model.vo.Dept2;

public class DeptController2 {
	private DeptService2 service = new DeptService2();

	public List<Dept2> selectList() {
		return service.selectList();
	}

	public int insert(Dept2 vo) {
		return service.insert(vo);
	}

	public int delete(int deptno) {
		return service.delete(deptno);
	}
}
