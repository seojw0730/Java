package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.EmpService;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpController {
	private EmpService service = new EmpService();

	public Emp selectOne(int empno) {
		Emp result = null;
		result = service.selectOne(empno);
		return result;
	}
	
	public List<Emp> selectList() {
		List<Emp> result = null;
		result = service.selectList();
		return result;
	}

	public int insert(Emp vo) {
		int result = -1;
		result = service.insert(vo);
		return result;
	}

	public int delete(int empno) {
		int result = -1;
		result = service.delete(empno);
		return result;
	}
}
