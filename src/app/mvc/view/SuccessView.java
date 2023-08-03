package app.mvc.view;

import java.util.List;
import java.util.Map;

import app.mvc.dto.ItemDTO;
import app.mvc.dto.ReceiptDTO;

public class SuccessView {

	public static void messagePrint(String message) {
		System.out.println(message);

	}
	
	//상품 전체 출력
	public static void printMenuList(List<ItemDTO> list) {
		System.out.println("-------상품 "+list.size()+"개 ---------");
		for(ItemDTO itemDto : list) {
			System.out.println(itemDto);
		}
		System.out.println();
	}

	public static void printViewCart(int member_no, Map<Integer, Integer> cart) {
		System.out.println("장바구니가 비어있습니다.");

		for (Integer key : cart.keySet()) {
			int itemNo = key;// 상품번호
			int cnt = cart.get(key);// 수량
			System.out.println(itemNo + "번 : " + cnt + "개");
		}
	}

	// 영수증 출력
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
