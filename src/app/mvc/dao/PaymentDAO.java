package app.mvc.dao;

import java.util.Map;
import app.mvc.dto.ReceiptDTO;
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
	 * 총 결제 금액 구하기
	 * @author 황혜령
	 * @return int
	 */
	int calcOfPaymentAmount();

	/**
	 * 주문 내역 추가하기
	 * @author 황혜령
	 * @return int
	 */
	int insertOrderInfo()  throws SQLException;

	/**
	 * 재고량 감소시키기
	 * @author 황혜령
	 * @return int
	 */
	int[] updateItemStock(Connection conn) throws SQLException;

	/**
	 * 주문 상세 내역 추가하기
	 * @author 황혜령
	 * @param OrderDTO
	 * @return int - 추가된 row 수
	 */
	int[] insertOrderDetail(Connection conn) throws SQLException ;

	/**
	 * 포인트 적립하기
	 * @author 황혜령
	 * @param OrderDTO
	 * @return int - 변경된 row 수
	 */
	int updateMemberAddPoint(OrderDTO orderDto);

	/**
	 * 포인트 차감하기
	 * @author 황혜령
	 * @param OrderDTO
	 * @return int - 변경된 row 수
	 */
	int updateMemberUsePoint(OrderDTO dorDto);
}
