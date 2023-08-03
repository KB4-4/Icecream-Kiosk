package app.mvc.service;

import app.mvc.dto.MemberDTO;

import java.sql.SQLException;

public class MemberServiceImpl implements MemberService{

    @Override
    public int memberInsert(String phone) {
        return 0;
    }

    @Override
    public MemberDTO memberLogin(String phone) throws SQLException {
        return null;
    }
}
