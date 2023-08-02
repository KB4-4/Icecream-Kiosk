package app.mvc.service;

import app.mvc.dao.PaymentDAO;
import app.mvc.dao.PaymentDAOImpl;
import app.mvc.dto.MemberDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.exception.SearchWrongException;

public class PaymentServiceImpl implements PaymentService {
	
	private PaymentServiceImpl() {};
	private static PaymentService instance = new PaymentServiceImpl();
	public static PaymentService getInstance() {
		return instance;
	}
	
	private PaymentDAO paymentDAO = PaymentDAOImpl.getInstance();

	@Override
	public OrderDTO selectOrderList(MemberDTO memberDTO) throws SearchWrongException {
		OrderDTO orderDto = paymentDAO.selectOrderList(memberDTO);
		if(orderDto == null) {
			throw new SearchWrongException("해당 주문 정보가 없습니다.");
		}
		return orderDto;
	}

	@Override
	public void selectOrderNo(MemberDTO memberDTO) throws SearchWrongException {
		int result = paymentDAO.selectOrderNo(memberDTO);
		if(result == 0) {
			throw new SearchWrongException("해당 주문 정보가 없습니다");
		}
	}

}
