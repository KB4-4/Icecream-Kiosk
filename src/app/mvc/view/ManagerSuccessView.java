package app.mvc.view;

import java.util.List;

import app.mvc.dto.ItemDTO;
import app.mvc.dto.OrderDTO;

public class ManagerSuccessView {

	public static void selectOrderPrint(List<OrderDTO> list) {
		System.out.println("----주문 내역 (" + list.size() + ") 개 ------------------");
		for (OrderDTO orderDto : list) {
			System.out.println(orderDto);// board.toString()호출
		}
	}

	public static void selectItemPrint(List<ItemDTO> list) {
		System.out.println("---- 아이스크림 종류 (" + list.size() + ") 개 ------------------");
		for (ItemDTO itemDto : list) {
			System.out.println(itemDto);// board.toString()호출
		}
	}

	public static void selectTop3ItemPrint(List<String> list) {
		System.out.println("---- 아이스크림 Top3 (" + list.size() + ") 개 ------------------");
		int num = 1;
		for (String iceream : list) {
			System.out.println(num++ + "순위: " + iceream);// board.toString()호출
		}
	}

	public static void messagePrint(String message) {
		System.out.println(message);
	}
}
