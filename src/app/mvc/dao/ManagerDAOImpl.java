package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import app.mvc.common.DBManager;
import app.mvc.dto.ItemDTO;
import app.mvc.dto.MemberDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public class ManagerDAOImpl implements ManagerDAO {
	private static ManagerDAO instance = new ManagerDAOImpl();
	
	private ManagerDAOImpl() {}
	
	public static ManagerDAO getInstance() {
		return instance;
	}

	@Override // 1. 모든 주문 검색
	public List<OrderDTO> selectOrderAll() throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<app.mvc.dto.OrderDTO> list = new ArrayList<>();
		String sql="select order_no, member_no, order_date, payment from orders";
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
			//				e.printStackTrace();
			throw new SearchWrongException("전체 주문 검색에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}
 
	@Override // 2. 기간별 주문 검색(매출액)
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
		}
		String sql="select sum(payment)\r\n"
				+ "from (select order_no, member_no, order_date, payment from orders\r\n"
				+ "where order_date > sysdate - ?\r\n"
				+ "order by order_date desc)";
		// ?  viewDays
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

	@Override // 3. 모든 아이템 검색
	public List<ItemDTO> selectItemAll() throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<ItemDTO> list = new ArrayList<>();
		String sql= "select item_no, item_name, price, stock, info from item";
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
			//	e.printStackTrace();
			throw new SearchWrongException("전체 아이스크림 검색에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return list;
	}
	
	@Override // 4. 인기 아이템 검색(top3)
	public List<String> selectItemTop3() throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<>();
		String icecreamName = null;
		String sql = "select item_name from item "
				+ "where item_no in "
				+ "(select item_no from "
				+ "(select item_no from order_detail group by item_no order by sum(qty) desc) "
				+ "where rownum <= 3)";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				icecreamName = rs.getString("item_name");
				list.add(icecreamName);
			}
		} catch (SQLException e) {
//			e.printStackTrace();
			throw new SearchWrongException("top3 아이스크림 검색에 오류가 발생했습니다.");
		}
		return list;
	} 

	@Override // 5. 아이템 추가
	public int insertItem(ItemDTO itemDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql="insert into item (item_no, item_name, price, stock, info) "
				+ "values (item_seq.nextval, ?, ?, ?, ?)";
		// 1. itemDTO.getItemNo();
		// 2. itemDTO.getItemName();
		// 3. itemDTO.getPrice();
		// 4. itemDTO.getStock();
		// 5. itemDTO.getInfo();
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

	@Override // 6. 아이템 이름으로 삭제
	public int deleteItemByItemName(String itemName) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql="delete from item where item_name = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, itemName);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DMLException("아이스크림 메뉴 삭제에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

	@Override // 7. 아이템 아이템번호로 선택한 후 수정(재고관리)
	public int updateItemStock(ItemDTO itemDTO) throws DMLException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		String sql="update item set stock = ?+stock where item_name = ? ";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, itemDTO.getStock());
			ps.setString(2, itemDTO.getItemName());
			
			result = ps.executeUpdate();
		}  catch (SQLException e) {
			//e.printStackTrace();
			throw new DMLException("아이스크림 재고관리에 오류가 발생했습니다.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}
}
