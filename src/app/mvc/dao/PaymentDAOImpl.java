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

}
