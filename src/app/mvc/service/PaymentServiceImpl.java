package app.mvc.service;

import java.sql.SQLException;

import app.mvc.dao.PaymentDAO;
import app.mvc.dao.PaymentDAOImpl;
import app.mvc.exception.NotFoundException;
import app.mvc.exception.PayException;
import app.mvc.exception.SearchWrongException;

public class PaymentServiceImpl implements PaymentService {
	private int pay = 0;

	private PaymentServiceImpl() {
	};

	private static PaymentService instance = new PaymentServiceImpl();

	public static PaymentService getInstance() {
		return instance;
	}

	private PaymentDAO paymentDAO = PaymentDAOImpl.getInstance();

	/**
	 * 주문번호 출력
	 */
	@Override
	public int selectOrderNo(int member_id) throws SearchWrongException {
		int result = paymentDAO.selectOrderNo(member_id);
		if (result == 0) {
			throw new SearchWrongException("해당 주문 정보가 없습니다");
		}
		return result;
	}

	/**
	 * 카드 결제
	 */
	@Override
	public int payByCredit() throws PayException, SQLException {
		pay = paymentDAO.calcOfPaymentAmount();

		// 결제 성공 여부 확인
		if ((int) (Math.random() * 128) == 1)
			throw new PayException("카드 잔액 부족");

		int result = paymentDAO.updateMemberAddPoint(pay);
		if (result == 0)
			throw new PayException("결제 오류");

		return result;
	}

	/**
	 * 포인트 결제
	 */
	@Override
	public int payByPoint() throws PayException, NotFoundException, SQLException {
		pay = paymentDAO.calcOfPaymentAmount();

		// 포인트로 전액 결제 가능 여부 확인
		if (paymentDAO.selectMemberPoint() < pay)
			throw new PayException("포인트 잔액 부족");

		int result = paymentDAO.updateMemberUsePoint(pay);
		if (result == 0)
			throw new PayException("결제 오류");

		return result;
	}

}
