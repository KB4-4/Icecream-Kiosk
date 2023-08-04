package app.mvc.controller;

import app.mvc.exception.SearchWrongException;
import app.mvc.service.PaymentService;
import app.mvc.service.PaymentServiceImpl;
import app.mvc.session.Session;
import app.mvc.view.FailView;
import app.mvc.view.MenuView;
import app.mvc.view.SuccessView;

public class PaymentController {
	private static PaymentService paymentService = PaymentServiceImpl.getInstance();

	/**
	 * 주문번호 출력
	 */
	public static void selectOrderNo(int member_no) {
		try {
			System.out.println("==================" + "\n");
			SuccessView.messagePrint("   주문번호: " + paymentService.selectOrderNo(member_no) + "\n");
			System.out.println("==================");
		} catch (SearchWrongException e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	/**
	 * 결제 및 주문 정보 업데이트
	 */
	public static void updateMemberAddPoint(int choice) {
		try {
			// 카드 결제
			if (choice == 1) {
				paymentService.payByCredit();
				SuccessView.messagePrint("결제가 완료 되었습니다.");
				PaymentController.selectOrderNo(Session.getInstance().getMember_no());
			}
			// 포인트 결제
			else if (choice == 2) {
				paymentService.payByPoint();
				SuccessView.messagePrint("결제가 완료 되었습니다.");
				PaymentController.selectOrderNo(Session.getInstance().getMember_no());
			} else {
				FailView.errorMessage("잘못된 입력입니다.");
			}
			MenuView.logout(Session.getInstance().getMember_no()); // 에러 발생시 로그아웃 후 메인화면으로 연결
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
}
