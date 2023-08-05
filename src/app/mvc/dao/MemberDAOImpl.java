package app.mvc.dao;

import app.mvc.common.DBManager;
import app.mvc.dto.MemberDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAO instance = new MemberDAOImpl();

	private MemberDAOImpl() {
	}

	public static MemberDAO getInstance() {
		return instance;
	}

	/**
	 * 회원가입
	 * insert
	 */
	@Override
	public int memberInsert(String phone) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into member values(MEMBER_SEQ.nextval, ?, DEFAULT, default)";
		int result = 0;
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, phone);
			result = ps.executeUpdate();

		} catch (SQLException e) {
			throw new DMLException();
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	/**
	 * 로그인
	 * select
	 */
	@Override
	public MemberDTO memberLogin(String phone) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select member_no, phone, point, grade from member where phone = ?";
		MemberDTO memberDTO = null;

		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, phone);
			rs = ps.executeQuery();

			if (rs.next()) {
				int member_no = rs.getInt("member_no");
				String phone_db = rs.getString("phone");
				int point = rs.getInt("point");
				int grade = rs.getInt("grade");

				memberDTO = new MemberDTO(member_no, phone_db, point, grade);
			}
		} catch (SQLException e) {
			throw new SearchWrongException();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return memberDTO;
	}
}
