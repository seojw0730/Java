package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.DeptService;
import kh.mclass.jdbc.model.vo.Dept;

public class DeptController {
	private DeptService service = new DeptService();

	public Dept selectOne(int deptno) {
		Dept result = null;
		result = service.selectOne(deptno);
		return result;
	}

	public List<Dept> selectList() {
		List<Dept> result = null;
		result = service.selectList();
		return result;
	}

	public int insert(Dept vo) {
		int result = -1;
		result = service.insert(vo);
		return result;
	}

	public int delete(int deptno) {
		int result = -1;
		result = service.delete(deptno);
		return result;
	}
}
