package app.mvc.dao;

import app.mvc.common.DBManager;
import app.mvc.dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAOImpl implements MemberDAO{

    private static MemberDAO instance = new MemberDAOImpl();

    @Override
    public int memberInsert(String phone) throws SQLException{

        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into member values(MEMBER_SEQ.nextval, '010-4444-4444', DEFAULT, 4)";
        int result = 0;

        try{
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);



        }catch(SQLException e){
            e.printStackTrace();
        }finally{

        }
        return 0;
    }

    @Override
    public MemberDTO memberLogin(String phone) throws SQLException {
        return null;
    }
}
