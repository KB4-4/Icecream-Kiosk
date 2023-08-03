package app.mvc.dao;

import app.mvc.dto.MemberDTO;

import java.sql.SQLException;

public interface MemberDAO {

    /**
     * 회원가입
     * */
    int memberInsert(String phone) throws SQLException;

    /**
     * 회원 로그인
     * */
    MemberDTO memberLogin(String phone) throws SQLException;

}
