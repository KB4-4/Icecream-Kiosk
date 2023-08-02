package app.mvc.dao;

import app.mvc.dto.MemberDTO;
import app.mvc.dto.OrderDTO;

public interface PaymentDAO {
	
	
	/**
	 * 영수증 출력을 위한 주문 번호, 주문 날짜, 금액 검색하기
	 * select order_no, order_date, payment from orders where member_no=?"
	 * 
	 * @author 장재은
	 * @param memberDTO
	 * @return 
	 */
	
	OrderDTO selectOrderList(MemberDTO memberDTO);

	/**
	 * 영수증 미출력시 안내할 주문 번호 검색하기
	 * 
	 * @author 장재은
	 * @param memberDTO
	 * @return
	 */
	int selectOrderNo(MemberDTO memberDTO);
	
	

}
