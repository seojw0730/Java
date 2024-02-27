package kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import static kh.mclass.jdbc.common.JdbcTemplate.*;
import kh.mclass.jdbc.model.dao.DeptDao;
import kh.mclass.jdbc.model.vo.Dept;

public class DeptService {
// Connection 객체 / close
// conn - commit / rollback
	private DeptDao dao = new DeptDao();

	public List<Dept> selectList() {
		List<Dept> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}

	public int insert(Dept vo) {
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
