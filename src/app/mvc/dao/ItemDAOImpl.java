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
	private static ItemDAO instance = new ItemDAOImpl();

	private ItemDAOImpl() {
	}

	public static ItemDAO getInstance() {
		return instance;
	}

	/**
	 * 아이스크림 메뉴 가져오기
	 * select
	 */
	@Override
	public List<ItemDTO> getItems() throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ItemDTO> list = new ArrayList<>();
		String sql = "select * from item order by item_no";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ItemDTO itemDto = new ItemDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
				list.add(itemDto);
			}
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	/**
	 * itemNo에 해당하는 정보 검색(메뉴 재고 파악 목적)
	 * select
	 */
	@Override
	public ItemDTO itemsSelectByItemsId(int itemNo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ItemDTO item = null;
		String sql = "select * from item where item_no = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemNo);
			rs = ps.executeQuery();

			if (rs.next()) {
				item = new ItemDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5));
			}
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return item;
	}

}