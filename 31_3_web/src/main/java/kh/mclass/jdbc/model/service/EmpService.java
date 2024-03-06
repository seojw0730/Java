package kh.mclass.jdbc.model.service;

import java.sql.Connection;
import java.util.List;

import static kh.mclass.jdbc.common.JdbcTemplate.*;
import kh.mclass.jdbc.model.dao.EmpDao;
import kh.mclass.jdbc.model.vo.Emp;

public class EmpService {
	private EmpDao dao = new EmpDao();

	public Emp selectOne(int empno) {
		Emp result = null;
		Connection con = getConnection();
		result = dao.selectOne(con, empno);
		close(con);
		return result;
	}
	
	public List<Emp> selectList() {
		List<Emp> result = null;
		Connection con = getConnection();
		result = dao.selectList(con);
		close(con);
		return result;
	}

	public int insert(Emp vo) {
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

	public int delete(int empno) {
		int result = -1;
		Connection con = getConnection();
		result = dao.delete(con, empno);
		autoCommit(con, false);
		if (result > 0)
			commit(con);
		else
			rollback(con);
		close(con);
		return result;
	}
}
