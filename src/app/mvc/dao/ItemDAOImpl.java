package app.mvc.dao;

import app.mvc.common.DBManager;
import app.mvc.dto.ItemDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAOImpl implements ItemDAO {

//    @Override
//    public List<ItemDTO> cartSelect() throws SQLException {
//        Connection con=null;
//        PreparedStatement ps=null;
//        ResultSet rs=null;
//        List<ItemDTO> list = new ArrayList<>();
//        String sql = "select * from item order by item_no";
//        try {
//            con = DBManager.getConnection();
//            ps= con.prepareStatement(sql);
//            rs = ps.executeQuery();
//
//            while(rs.next()) {
//                ItemDTO item  = new ItemDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
//                list.add(item);
//            }
//        }finally {
//            DBManager.releaseConnection(con, ps, rs);
//        }
//        return list;
//    }

    @Override
    public ItemDTO itemsSelectByItemsId(int itemNo) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ItemDTO item =null;
        try {
            con = DBManager.getConnection();
            ps= con.prepareStatement("select * from item where item_no = ?");
            ps.setInt(1, itemNo);
            rs = ps.executeQuery();

            if(rs.next()) {
                item  = new ItemDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
            }
        }finally {
            DBManager.releaseConnection(con, ps, rs);
        }
        return item;
    }
}
