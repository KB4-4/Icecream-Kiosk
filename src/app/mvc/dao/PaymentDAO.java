package app.mvc.dao;

import java.sql.Connection;
import java.sql.SQLException;

import app.mvc.exception.NotFoundException;
import app.mvc.exception.PayException;
import app.mvc.exception.SearchWrongException;

public interface PaymentDAO {

	/**
	 * 1. 결제 후 안내할 주문 번호 조회
	 * 
	 * @author 장재은
	 * @param member_no 회원번호
	 * @return int 주문번호
	 */
	int selectOrderNo(int member_no);

	/**
	 * 2. 장바구니에 담은 상품 총액 계산
	 * 
	 * @author 황혜령
	 * @return int 장바구니 총 금액
	 * @throws 상품 정보가 없을 때 ▶ SearchWrongException
	 */
	int calcOfPaymentAmount() throws SearchWrongException;

	/**
	 * 3. 주문 테이블에 장바구니 정보 삽입
	 * 
	 * @author 황혜령
	 * @param conn
	 * @param pay  총 결제 금액
	 * @return int 주문 테이블에 저장 여부 판별(성공시 = 1)
	 * @throws 주문이 완료되지 않았을 때 ▶ SQLException
	 */
	int insertOrderInfo(Connection conn, int pay) throws SQLException;

	/**
	 * 4. 주문 상세 테이블에 장바구니 정보 삽입
	 * 
	 * @author 황혜령
	 * @param conn
	 * @return int[] 장바구니 정보
	 * @throws 주문 상세 테이블에 저장 실패 시 ▶ SQLException
	 */
	int[] insertOrderDetail(Connection conn) throws SQLException;

	/**
	 * 5. 적립할 포인트 계산
	 * 
	 * @author 황혜령
	 * @param pay 결제액
	 * @return int 결제 후 적립된 포인트
	 * @throws SQLException
	 */
	int calcPoint(int pay) throws SQLException;

	/**
	 * 6. 포인트 적립
	 * 
	 * @param pay 결제액
	 * @return int 결제 후 적립된 포인트
	 * @throws 결제가 완료되지 않았을 때 ▶ PayException
	 * @throws 포인트 적립에 실패했을 때 ▶ SQLException
	 */
	int updateMemberAddPoint(int pay) throws PayException, SQLException;

	/**
	 * 7. 잔여 포인트 조회
	 * 
	 * @author 황혜령
	 * @return int 잔여 포인트
	 * @throws 회원 정보가 없을 때 ▶ NotFoundException
	 */
	int selectMemberPoint() throws NotFoundException;

	/**
	 * 8. 포인트 사용
	 * 
	 * @author 황혜령
	 * @param pay 결제액
	 * @return int 포인트 결제 성공 여부(
	 * @throws 포인트가 결제 금액보다 적을 때▶ PayException
	 * @throws 포인트  결제에 실패했을 때 ▶ SQLException
	 */
	int updateMemberUsePoint(int pay) throws PayException, SQLException;

	/**
	 * 9. 상품 구매 후 재고 차감
	 * 
	 * @author 황혜령
	 * @param conn
	 * @return int[] 재고 차감
	 * @throws SQLException
	 */
	int[] updateItemStock(Connection conn) throws SQLException;

}
