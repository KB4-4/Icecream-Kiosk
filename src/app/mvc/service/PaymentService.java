package app.mvc.service;

import java.sql.SQLException;

import app.mvc.exception.NotFoundException;
import app.mvc.exception.PayException;
import app.mvc.exception.SearchWrongException;

public interface PaymentService {

	/**
	 * 1. 주문번호 출력
	 * 
	 * @author 장재은
	 * @param member_no 회원번호
	 * @return int 주문번호
	 * @throws 주문 정보가 없을 때 ▶ SearchWrongException
	 */
	int selectOrderNo(int member_no) throws SearchWrongException;

	/**
	 * 2. 카드 결제
	 * 
	 * @author 황혜령
	 * @return int 카드 결제 성공 여부(실패시 = 0)
	 * @throws 잔액 부족 및 결제 오류 ▶ PayException, SQLException
	 */
	int payByCredit() throws PayException, SQLException;

	/**
	 * 3. 포인트 결제
	 * 
	 * @author 황혜령
	 * @return int 포인트 결제 성공 여부(실패시 = 0)
	 * @throws 포인트 잔액 부족 및 결제 오류 ▶PayException, NotFoundException, SQLException
	 */
	int payByPoint() throws PayException, NotFoundException, SQLException;

}
