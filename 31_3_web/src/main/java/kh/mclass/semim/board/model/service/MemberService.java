package kh.mclass.semim.board.model.service;

import static kh.mclass.jdbc.common.JdbcTemplate.*;

import java.sql.Connection;
import java.util.List;

import kh.mclass.semim.member.model.dao.MemberDao;
import kh.mclass.semim.member.model.dto.MemberDto;
import kh.mclass.semim.member.model.dto.MemberInfoDto;
import kh.mclass.semim.member.model.dto.MemberLoginDto;

public class MemberService {
	private MemberDao dao = new MemberDao();
	
		// selectInfoLogin
		public MemberInfoDto selectInfoLogin(MemberLoginDto dto) {
			MemberInfoDto result = null;
			Connection con = getConnectionSemi(true);
			result = dao.selectInfoLogin(con, dto);
			close(con);
			return result;
		}
		
		// selectCheckId
		public int selectCheckId(String memId) {
			int result = -1;
			Connection con = getConnectionSemi(true);
			result = dao.selectCheckId(con, memId);
			close(con);
			return result;
		}
		
	 	// selectList - all
		public List<MemberDto> selectAllList() {
			List<MemberDto> result = null;
			Connection con = getConnectionSemi(true);
			result = dao.selectAllList(con);
			close(con);
			return result;
		}
		
		// selectOne
		public MemberDto selectOne(String memId) {
			MemberDto result = null;
			Connection con = getConnectionSemi(true);
			result = dao.selectOne(con, memId);
			close(con);
			return result;
		}
		
		// insert
		public int insert(MemberDto dto) {
			int result = -1;
			Connection con = getConnectionSemi(true);
			result = dao.insert(con, dto);
			close(con);
			return result;
		}
		
		// update
		public int update(MemberDto dto) {
			int result = -1;
			Connection con = getConnectionSemi(true);
			result = dao.update(con, dto);
			close(con);
			return result;
		}
		// delete
		public int delete(String memId) {
			int result = 0;
			Connection con = getConnectionSemi(true);
			result = dao.delete(con, memId);
			close(con);
			return result;
		}
}
