package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.SalgradeService;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeController {
	private SalgradeService service = new SalgradeService();

	public Salgrade selectOne(int grade) {
		Salgrade result = null;
		result = service.selectOne(grade);
		return result;
	}

	public List<Salgrade> selectList() {
		List<Salgrade> result = null;
		result = service.selectList();
		return result;
	}

	public int insert(Salgrade vo) {
		int result = -1;
		result = service.insert(vo);
		return result;
	}

	public int delete(int grade) {
		int result = -1;
		result = service.delete(grade);
		return result;
	}

	public int update(Salgrade vo) {
		int result = -1;
		result = service.update(vo);
		return result;
	}
}
