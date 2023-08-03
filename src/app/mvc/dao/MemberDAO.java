package app.mvc.dao;

import app.mvc.dto.MemberDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

import java.sql.SQLException;

public interface MemberDAO {

    /**
     * 회원가입
     * */
    int memberInsert(String phone) throws DMLException;

    /**
     * 회원 로그인
     * */
    MemberDTO memberLogin(String phone) throws SearchWrongException;

}
