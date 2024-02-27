package kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import static kh.mclass.jdbc.common.JdbcTemplate3.*;
import kh.mclass.jdbc.model.dao.DeptDao3;
import kh.mclass.jdbc.model.vo.Dept3;

public class DeptService3 {
	private DeptDao3 dao = new DeptDao3();

	public List<Dept3> selectList() {
		List<Dept3> result = null;
		Connection con = getConnection();
		result = dao.selectList(con);
		close(con);
		return result;
	}

	public int insert(Dept3 vo) {
		int result = -1;
		Connection con = getConnection();
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
