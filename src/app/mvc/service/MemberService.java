package app.mvc.service;

import app.mvc.dao.MemberDAO;
import app.mvc.dao.MemberDAOImpl;
import app.mvc.dto.MemberDTO;

import java.sql.SQLException;

public interface MemberService {
    MemberDAO memberDAO = new MemberDAOImpl();

    int memberInsert(String phone);
    MemberDTO memberLogin(String phone) throws SQLException;
}
