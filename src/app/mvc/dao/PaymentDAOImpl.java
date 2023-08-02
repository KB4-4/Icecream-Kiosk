package app.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.mvc.common.DBManager;
import app.mvc.dto.MemberDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.exception.SearchWrongException;

public class PaymentDAOImpl implements PaymentDAO {
	
	private PaymentDAOImpl() {};
	private static PaymentDAO instance = new PaymentDAOImpl();
	public static PaymentDAO getInstance() {
		return instance;
	}
	
	//영수증 출력
	@Override
	public OrderDTO selectOrderList(MemberDTO memberDTO) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		OrderDTO orderDTO = null;
		
		String sql = "select order_no, order_date, payment from orders where member_id = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, memberDTO.getMemberNo());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				orderDTO = new OrderDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
			}
		} catch(SQLException e) {
//			e.printStackTrace();
			throw new SearchWrongException(memberDTO.getMemberNo() + "주문 검색에 오류가 발생했습니다.\n 다시 이용해주세요.");
		} finally {
			DBManager.releaseConnection(con, ps, rs);
		}
		return orderDTO;
	}

	//영수증 출력x, 주문번호만 출력
	@Override
	public int selectOrderNo(MemberDTO memberDTO) throws SearchWrongException {
		Connection con = null;
		PreparedStatement ps = null;
		OrderDTO orderDTO = null;
		int result = 0;
		
		String sql = "select order_no from orders where member_id = ?";
		try {
			con = DBManager.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, memberDTO.getMemberNo());
			result = ps.executeUpdate();
		} catch(SQLException e) {
//			e.printStackTrace();
			throw new SearchWrongException(memberDTO.getMemberNo() + "주문번호 검색에 오류가 발생했습니다.\n 다시 이용해주세요.");
		} finally {
			DBManager.releaseConnection(con, ps);
		}
		return result;
	}

}
