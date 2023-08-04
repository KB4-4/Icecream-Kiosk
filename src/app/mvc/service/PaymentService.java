package app.mvc.service;

import java.sql.SQLException;

import app.mvc.exception.DMLException;
import app.mvc.exception.NotFoundException;
import app.mvc.exception.PayException;
import app.mvc.exception.SearchWrongException;

public interface PaymentService {
	
	/**
	 * 영수증 출력을 위한 주문 번호, 주문 날짜, 금액 검색
	 */
//	ReceiptDTO selectOrderList(int member_no) throws SearchWrongException;
	
	/**
	 * Session에 저장된 item_no로 item_name 검색 후, <item_name, qty> 반환
	 */
//	Map<String, Integer> searchItemName(Map<Integer, Integer> cart) throws SearchWrongException;
	
	/**
	 * 주문번호 출력
	 */
	int selectOrderNo(int member_no) throws SearchWrongException;
	
	/**
	 * 카드 결제
	 */
	int payByCredit() throws PayException, SQLException;
	
	/**
	 * 포인트 결제
	 */
	int payByPoint() throws PayException, NotFoundException, SQLException;
	
}
