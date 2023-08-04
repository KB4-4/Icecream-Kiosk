package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.mvc.common.DBManager;
import app.mvc.dto.ItemDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public class ManagerDAOImpl implements ManagerDAO {
	private static ManagerDAO instance = new ManagerDAOImpl();

	private ManagerDAOImpl() {
	}

	public static ManagerDAO getInstance() {
		return instance;
	}

	/**
	 * 모든 주문 내역 검색
	 */
	@Override
	public List<OrderDTO> selectOrderAll() throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<app.mvc.dto.OrderDTO> list = new ArrayList<>();
		String sql = "select order_no, member_no, order_date, payment from orders";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int orderNo = rs.getInt("order_no");
				int memberNo = rs.getInt("member_no");
				String orderDate = rs.getString("order_date");
				int payment = rs.getInt("payment");

				OrderDTO orderdto = new OrderDTO(orderNo, memberNo, orderDate, payment);
				list.add(orderdto);
			}
		} catch (SQLException e) {
			throw new SearchWrongException("전체 주문 검색에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	/**
	 * 기간별 주문 검색(매출액)
	 */
	@Override
	public int selectTotalSalesByPeriod(int period) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int totalSales = 0;
		// 3. 1년 동안의 매출 (기본)
		int viewDays = 365;
		int addPayment = 0;

		// 1. 하루 동안의 매출
		if (period == 1) {
			viewDays = 1;
			// 2. 일주일 동안의 매출
		} else if (period == 2) {
			viewDays = 7;
			// 3. 한달 동안의 매출
		} else if (period == 3) {
			viewDays = 30;
		}
		String sql = "select sum(payment)\r\n" + "from (select order_no, member_no, order_date, payment from orders\r\n"
				+ "where order_date > sysdate - ?\r\n" + "order by order_date desc)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, viewDays);
			rs = ps.executeQuery();
			while (rs.next()) {
				addPayment = rs.getInt("sum(payment)");
				totalSales += addPayment;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SearchWrongException("지정한 기간에 대한 게시물 검색에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return totalSales;
	}

	/**
	 * 모든 메뉴 검색
	 */
	@Override
	public List<ItemDTO> selectItemAll() throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ItemDTO> list = new ArrayList<>();
		String sql = "select item_no, item_name, price, stock, info from item order by item_no";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int itemNO = rs.getInt("item_no");
				String itemName = rs.getString("item_name");
				int price = rs.getInt("price");
				int stock = rs.getInt("stock");
				String info = rs.getString("info");

				ItemDTO itemDto = new ItemDTO(itemNO, itemName, price, stock, info);
				list.add(itemDto);
			}
		} catch (SQLException e) {
			throw new SearchWrongException("전체 아이스크림 검색에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}

	/**
	 * 인기 메뉴 검색(판매 빈도 TOP 3)
	 */
	@Override
	public List<String> selectItemTop3() throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<>();
		String icecreamName = null;
		String sql = "SELECT a.ITEM_NAME\r\n" + "FROM ITEM a\r\n" + "JOIN ORDER_DETAIL od ON a.ITEM_NO = od.ITEM_NO\r\n"
				+ "GROUP BY a.ITEM_NAME\r\n" + "ORDER BY SUM(od.QTY) DESC\r\n" + "FETCH FIRST 3 ROWS ONLY";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				icecreamName = rs.getString("item_name");
				list.add(icecreamName);
			}
		} catch (SQLException e) {
			throw new SearchWrongException("top3 아이스크림 검색에 오류가 발생했습니다.");
		}
		return list;
	}

	/**
	 * item 테이블에 메뉴 추가
	 */
	@Override
	public int insertItem(ItemDTO itemDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "insert into item (item_no, item_name, price, stock, info) "
				+ "values (item_seq.nextval, ?, ?, ?, ?)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, itemDTO.getItemName());
			ps.setInt(2, itemDTO.getPrice());
			ps.setInt(3, itemDTO.getStock());
			ps.setString(4, itemDTO.getInfo());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("아이스크림 추가에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	/**
	 * 메뉴 이름으로 삭제
	 */
	@Override
	public int deleteItemByItemName(String itemName) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "delete from item where item_name LIKE ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, itemName);

			result = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DMLException("아이스크림 메뉴 삭제에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	/**
	 * 메뉴 재고관리(메뉴 번호로 조회 후 수정)
	 */
	@Override
	public int updateItemStock(ItemDTO itemDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql = "update item set stock = ?+stock where item_name like ? ";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemDTO.getStock());
			ps.setString(2, itemDTO.getItemName());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			throw new DMLException("아이스크림 재고관리에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}
}
