package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import app.mvc.common.DBManager;
import app.mvc.dto.MemberDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.dto.ReceiptDTO;
import app.mvc.exception.SearchWrongException;

public class PaymentDAOImpl implements PaymentDAO {
	
	private PaymentDAOImpl() {};
	private static PaymentDAO instance = new PaymentDAOImpl();
	public static PaymentDAO getInstance() {
		return instance;
	}
	
	//영수증 출력
//	@Override
//	public ReceiptDTO selectOrderList(int member_no) throws SearchWrongException {
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		ReceiptDTO receiptDTO = null;
//		
//		String sql = "select order_no, order_date, payment, point from orders join member using(member_no) where member_id=?";
//		try {
//			con = DBManager.getConnection();
//			ps = con.prepareStatement(sql);
//			ps.setInt(1, member_no);
//			rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				receiptDTO = new ReceiptDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4));
//			}
//		} catch(SQLException e) {
////			e.printStackTrace();
//			throw new SearchWrongException(member_no + "주문 검색에 오류가 발생했습니다.\n 다시 이용해주세요.");
//		} finally {
//			DBManager.releaseConnection(con, ps, rs);
//		}
//		return receiptDTO;
//	}

	//영수증 출력x, 주문번호만 출력
	@Override
	public int selectOrderNo(int member_no) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		String sql = "select order_no from orders where member_no = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, member_no);
			result = ps.executeUpdate();
		} catch(SQLException e) {
//			e.printStackTrace();
			throw new SearchWrongException(member_no + "주문번호 검색에 오류가 발생했습니다.\n 다시 이용해주세요.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}
	@Override
	public int calcOfPaymentAmount() throws SearchWrongException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		int price = 0;

		//TODO: 세션값으로 바꾸기
		Map<Integer, Integer> cart = new HashMap<>();
		cart.put(1,1);
		cart.put(2,2);
		cart.put(5,6);
		cart.put(3,4);

		//모든 상품 가격 동일함
		String sql = "SELECT DISTINCT price FROM ITEM";

		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if(rs.next())
				price = rs.getInt("price");

			for(int item : cart.keySet())
				result += (cart.get(item) * price);

		}catch (SQLException e) {
			throw new SearchWrongException("상품 정보 불러오기에 실패했습니다.\n다시 이용해주세요");
		} finally {
			DBManager.releaseConnection(conn, ps, rs);
		}

		return result;
	}

	@Override
	public int insertOrderInfo() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO ORDERS values(order_seq.nextval, ?, DEFAULT, ?)";
		int result = 0;

		//TODO: 세션값으로 바꾸기
		int memId = 1;

		try {
			int pay = this.calcOfPaymentAmount();
			conn = DBManager.getConnection();
			conn.setAutoCommit(false);

			ps = conn.prepareStatement(sql);
			ps.setInt(1, memId);
			ps.setInt(2, pay);

			result = ps.executeUpdate();
			if(result == 0) {
				conn.rollback();
				throw new SQLException("주문이 완료되지 않았습니다.");
			}
			else {
				int[] re = this.insertOrderDetail(conn);
				for(int i : re) {
					if(i != 1) {
						conn.rollback();
						throw new SQLException("주문이 완료되지 않았습니다.");
					}
				}

				int[] res = this.updateItemStock(conn);
				for(int i : res) {
					if(i != 1) {
						conn.rollback();
						throw new SQLException("주문이 완료되지 않았습니다.");
					}
				}

				conn.commit();
			}

		} finally {
			DBManager.releaseConnection(conn, ps);
		}

		return result;
	}

	@Override
	public int[] insertOrderDetail(Connection conn) throws SQLException {
		//TODO: 세션값으로 바꾸기
		Map<Integer, Integer> cart = new HashMap<>();
		cart.put(1,1);
		cart.put(2,2);
		cart.put(5,6);
		cart.put(3,4);

		PreparedStatement ps = null;
		String sql = "INSERT INTO ORDER_DETAIL VALUES(order_detail_seq.nextval, order_seq.currval, ?, ?)";
		int[] result = null;

		try {
			ps = conn.prepareStatement(sql);

			for(int item : cart.keySet()) {
				ps.setInt(1, item);
				ps.setInt(2, cart.get(item));
				ps.addBatch();
				ps.clearParameters();
			}
			result = ps.executeBatch();

		} finally {
			DBManager.releaseConnection(null, ps, null);
		}

		return result;
	}

	@Override
	public int updateMemberAddPoint(OrderDTO orderDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMemberUsePoint(OrderDTO dorDto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] updateItemStock(Connection conn) throws SQLException {
		PreparedStatement ps = null;
		String sql = "update item set stock = (stock - ?) where item_no = ?";
		int[] result = null;

		try {
			//TODO: 세션값으로 바꾸기
			Map<Integer, Integer> cart = new HashMap<>();
			cart.put(6,4);
			cart.put(7,6);
			cart.put(8,2);
			cart.put(10,1);

			ps = conn.prepareStatement(sql);

			for(int item : cart.keySet()) {
				System.out.println(item + ": " + cart.get(item));
				ps.setInt(1, cart.get(item));
				ps.setInt(2, item);
				ps.addBatch();
				ps.clearParameters();
			}

			result = ps.executeBatch();
			for(int i : result)
				System.out.println(i);

		} finally {
			DBManager.releaseConnection(null, ps, null);
		}

		return result;
	}
}
