package kh.mclass.jdbc.model.service;

import static kh.mclass.jdbc.common.JdbcTemplate.autoCommit;
import static kh.mclass.jdbc.common.JdbcTemplate.close;
import static kh.mclass.jdbc.common.JdbcTemplate.commit;
import static kh.mclass.jdbc.common.JdbcTemplate.getConnection;
import static kh.mclass.jdbc.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import kh.mclass.jdbc.model.dao.DeptDao;
import kh.mclass.jdbc.model.vo.Dept;

public class DeptService {
	private DeptDao dao = new DeptDao();

	public Dept selectOne(int deptno) {
		Dept result = null;
		Connection con = getConnection();
		result = dao.selectOne(con, deptno);
		close(con);
		return result;
	}
	public List<Dept> selectList() {
		List<Dept> result = null;
		Connection con = getConnection();
		result = dao.selectList(con);
		close(con);
		return result;
	}

	public int insert(Dept vo) {
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

	public int delete(int deptno) {
		int result = -1;
		Connection con = getConnection();
		result = dao.delete(con, deptno);
		autoCommit(con, false);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
}
