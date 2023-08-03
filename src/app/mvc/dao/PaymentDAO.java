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

	
	

}
