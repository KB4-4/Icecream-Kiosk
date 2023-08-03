package app.mvc.view;

import java.util.Map;
import app.mvc.dto.ReceiptDTO;

public class SuccessView {
	
	public static void messagePrint(String message) {
		System.out.println(message);
		
	}	
	
	//영수증 출력
	public static void selectOrderListPrint(ReceiptDTO receiptDTO, Map<Integer, Integer> cart) {
		StringBuilder builder = new StringBuilder();
		
		builder.append("============= 영수증 =============\n");
		builder.append("* 주문번호: ");
		builder.append(receiptDTO.getOrderNo() + "\n");
		builder.append("* 주문일시: ");
		builder.append(receiptDTO.getOrderDate() + "\n");
		builder.append("* 주문내역: \n");
		builder.append("* 총 결제 금액: ");
		builder.append(receiptDTO.getPayment() + "\n");
		builder.append("* 잔여 포인트: ");
		builder.append(receiptDTO.getPoint() + "\n");
		builder.append("==================================\n");
		builder.toString();
		System.out.println(builder);
	}
}
