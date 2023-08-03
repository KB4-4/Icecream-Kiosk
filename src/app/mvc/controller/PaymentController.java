package app.mvc.controller;

import app.mvc.dto.MemberDTO;
import app.mvc.exception.SearchWrongException;
import app.mvc.service.PaymentService;
import app.mvc.service.PaymentServiceImpl;
import app.mvc.view.FailView;
import app.mvc.view.SuccessView;

public class PaymentController {
	private static PaymentService paymentService = PaymentServiceImpl.getInstance();
	
	/**
	 * 영수증 출력
	 */
//	public static void selectOrderList(int member_no) {
//		try {
//			SuccessView.selectOrderListPrint(paymentService.selectOrderList(member_no), paymentService.searchItemName(Session.cart));
//		} catch (SearchWrongException e) {
//			FailView.errorMessage(e.getMessage());
//		}
//	}
	
	/**
	 * 주문번호 출력
	 */
	public static void selectOrderNo(int member_no) {
		try {
			SuccessView.messagePrint("주문번호: "+paymentService.selectOrderNo(member_no)+"\n");
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
