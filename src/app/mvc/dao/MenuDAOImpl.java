package app.mvc.dao;

import app.mvc.common.DBManager;
import app.mvc.dto.ItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MenuDAOImpl implements  MenuDAO {
    private static MenuDAO instance = new MenuDAOImpl();

    private MenuDAOImpl() {}

    public static MenuDAO getInstance() {
        return instance;
    }
    //모든 메뉴 가져와서 보여주기
    public List<ItemDTO> getItems() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ItemDTO> list = new ArrayList<>();
        String sql = "select * from item";

        try {
            con = DBManager.getConnection();
            ps = con.prepareStatement(sql);

            //db 쿼리를 전송 - executeXxx
            rs = ps.executeQuery();
            while(rs.next()) {
                //열을 조회
                int itemNo = rs.getInt("item_no");
                String itemName = rs.getString("item_name");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                String info = rs.getString("info");
                ItemDTO itemDto = new ItemDTO(itemNo, itemName, price, stock, info);
                list.add(itemDto);
            }
        }
        catch(SQLException e) {
            throw new Exception();
        } finally {
            DBManager.releaseConnection(con, ps, rs);
        }
        return list;
    }
}
