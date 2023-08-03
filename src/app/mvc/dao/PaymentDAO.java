package app.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import app.mvc.dto.OrderDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public interface PaymentDAO {
	
	
	/**
	 * 영수증 출력을 위한 주문 번호, 주문 날짜, 금액 검색하기
	 * select order_no, order_date, payment from orders where member_no=?"
	 * 
	 * @author 장재은
	 * @param memberDTO
	 * @return 
	 */
	
//	ReceiptDTO selectOrderList(int member_no) throws SearchWrongException;

	/**
	 * 영수증 출력을 위한 주문 상세내역 검색하기
	 * 
	 * @author 장재은
	 * @param memberDTO
	 * @return
	 */
//	Map<String, Integer> searchItemName(Map<Integer, Integer> cart) throws SearchWrongException;
	
	
	/**
	 * 영수증 미출력시 안내할 주문 번호 검색하기
	 * 
	 * @author 장재은
	 * @param memberDTO
	 * @return
	 */
	int selectOrderNo(int member_no);

	/**
	 * 장바구니에 담은 상품 총액 계산
	 * @author 황혜령
	 * @return
	 * @throws SearchWrongException
	 */
	int calcOfPaymentAmount() throws SearchWrongException;

	
	/**
	 * 주문 테이블에 장바구니 정보 삽입
	 * @author 황혜령
	 * @return
	 * @throws SQLException
	 */
	int insertOrderInfo(int pay) throws SQLException;

	/**
	 * 주문 상세 테이블에 장바구니 정보 삽입
	 * @author 황혜령
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	int[] insertOrderDetail(Connection conn) throws SQLException;

	/**
	 * 적립할 포인트 계산
	 * @author 황혜령
	 * @return
	 */
	int calcPoint(int pay) throws SQLException;
	
	/**
	 * 포인트 적립
	 * @author 황혜령
	 * @param orderDto
	 * @return
	 */
	int updateMemberAddPoint(int pay) throws DMLException;

	/**
	 * 포인트 사용
	 * @author 황혜령
	 * @param dorDto
	 * @return
	 */
	int updateMemberUsePoint(int pay);

	/**
	 * 상품 구매 후 재고 차감
	 * @author 황혜령
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	int[] updateItemStock(Connection conn) throws SQLException;

}
