package app.mvc.view;

import java.util.List;

import app.mvc.dto.OrderDTO;

public class ManagerSuccessView {

	public static void selectPrint(List<OrderDTO> list) {
		System.out.println("----Order LIST ("+list.size()+") 개 ------------------");
		for(OrderDTO orderDto : list) {
			System.out.println(orderDto);//board.toString()호출
		}
		
	}
}
