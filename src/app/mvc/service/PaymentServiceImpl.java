package app.mvc.service;

import java.util.Map;

import app.mvc.dao.PaymentDAO;
import app.mvc.dao.PaymentDAOImpl;
import app.mvc.dto.MemberDTO;
import app.mvc.dto.ReceiptDTO;
import app.mvc.exception.SearchWrongException;

public class PaymentServiceImpl implements PaymentService {
	
	private PaymentServiceImpl() {};
	private static PaymentService instance = new PaymentServiceImpl();
	public static PaymentService getInstance() {
		return instance;
	}
	
	private PaymentDAO paymentDAO = PaymentDAOImpl.getInstance();

//	@Override
//	public ReceiptDTO selectOrderList(int member_id) throws SearchWrongException {
//		ReceiptDTO receiptDTO = paymentDAO.selectOrderList(member_id);
//		if(receiptDTO == null) {
//			throw new SearchWrongException("해당 주문 정보가 없습니다.");
//		}
//		return receiptDTO;
//	}

	@Override
	public int selectOrderNo(int member_id) throws SearchWrongException {
		int result = paymentDAO.selectOrderNo(member_id);
		if(result == 0) {
			throw new SearchWrongException("해당 주문 정보가 없습니다");
		}
		return result;
	}

}
