package app.mvc.service;

import app.mvc.dao.MemberDAO;
import app.mvc.dao.MemberDAOImpl;
import app.mvc.dto.MemberDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

import java.sql.SQLException;

public interface MemberService {

    /**
     * 회원가입
     * */
    void memberInsert(String phone) throws DMLException;

    /**
     * 로그인
     * */
    MemberDTO memberLogin(String phone) throws SearchWrongException;
}
