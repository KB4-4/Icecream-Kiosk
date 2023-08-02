package app.mvc.service;

import app.mvc.dto.MemberDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.exception.SearchWrongException;

public interface PaymentService {
	
	/**
	 * 영수증 출력을 위한 주문 번호, 주문 날짜, 금액 검색
	 */
	OrderDTO selectOrderList(MemberDTO memberDTO) throws SearchWrongException;
	
	/**
	 * 영수증 미출력시 안내할 주문 번호 검색
	 */
	void selectOrderNo(MemberDTO memberDTO) throws SearchWrongException;
}
