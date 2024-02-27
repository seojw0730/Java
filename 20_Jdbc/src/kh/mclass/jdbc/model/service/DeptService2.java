package kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import static kh.mclass.jdbc.common.JdbcTemplate2.*;
import kh.mclass.jdbc.model.dao.DeptDao2;
import kh.mclass.jdbc.model.vo.Dept2;

public class DeptService2 {
	private DeptDao2 dao = new DeptDao2();

	public List<Dept2> selectList() {
		List<Dept2> result = null;
		Connection con = getConnection();
		result = dao.selectList(con);
		close(con);
		return result;
	}

	public int insert(Dept2 vo) {
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

	public int delete(int deptno) {
		int result = -1;
		Connection con = getConnection();
		autoCommit(con, false);
		result = dao.delete(con, deptno);
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		close(con);
		return result;
	}
}
