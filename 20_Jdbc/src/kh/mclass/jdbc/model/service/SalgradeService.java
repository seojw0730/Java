package kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import static kh.mclass.jdbc.common.JdbcTemplate.*;
import kh.mclass.jdbc.model.dao.SalgradeDao;
import kh.mclass.jdbc.model.vo.Salgrade;

public class SalgradeService {
	private SalgradeDao dao = new SalgradeDao();

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
		autoCommit(con, false);
		result = dao.insert(con, vo);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}

	public int delete(int grade) {
		int result = -1;
		Connection con = getConnection();
		autoCommit(con, false);
		result = dao.delete(con, grade);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
}
