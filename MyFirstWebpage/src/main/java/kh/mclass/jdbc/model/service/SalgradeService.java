package kh.mclass.jdbc.model.service;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.mclass.jdbc.model.dao.SalgradeDao;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeService {
	private SalgradeDao dao = new SalgradeDao();

	public Salgrade selectOne(int grade) {
		Salgrade result = null;
		Connection con = getConnection();
		result = dao.selectOne(con, grade);
		close(con);
		return result;
	}

	public List<Salgrade> selectList() {
		List<Salgrade> result = null;
		Connection con = getConnection();
		result = dao.selectList(con);
		close(con);
		return result;
	}

	public int insert(Salgrade vo) {
		int result = -1;
		Connection con = getConnection();
		result = dao.insert(con, vo);
		autoCommit(con, false);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int delete(int grade) {
		int result = -1;
		Connection con = getConnection();
		result = dao.delete(con, grade);
		autoCommit(con, false);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}

	public int update(Salgrade vo) {
		int result = -1;
		Connection con = getConnection();
		result = dao.update(con, vo);
		autoCommit(con, false);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
}
