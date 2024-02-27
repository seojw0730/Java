package kh.mclass.jdbc.controller;

import java.util.List;

import kh.mclass.jdbc.model.service.SalgradeService;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeController {
	private SalgradeService service = new SalgradeService();

	public List<Salgrade> selectList() {
		return service.selectList();
	}

	public int insert(Salgrade vo) {
		return service.insert(vo);
	}

	public int delete(int grade) {
		return service.delete(grade);
	}
}
