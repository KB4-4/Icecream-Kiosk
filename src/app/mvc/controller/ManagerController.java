package app.mvc.controller;

import java.util.List;

import app.mvc.dto.ItemDTO;
import app.mvc.dto.MemberDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;
import app.mvc.service.ManagerService;
import app.mvc.service.ManagerServiceImpl;
import app.mvc.view.FailView;
import app.mvc.view.ManagerSuccessView;
import app.mvc.view.SuccessView;

public class ManagerController {
	private static ManagerService managerService = ManagerServiceImpl.getInstance();
	/**
	 * 1. 모든 주문 검색
	 * @author 김현지
	 */
	public static void selectOrderAll() {
		try {
			List<OrderDTO> list = managerService.selectOrderAll();
			ManagerSuccessView.selectOrderPrint(list);
		} catch (SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
		   }
	}
	
	/**
	 * 2. 기간별 주문 검색(매출액)
	 * 1. 하루
	 * 2. 일주일
	 * 3. 한달
	 * @author 김현지
	 */
	public static void selectTotalSalesByPeriod(int period) {
		try {
			int totalSales = managerService.selectTotalSalesByPeriod(period);
			ManagerSuccessView.messagePrint("해당 기간 동안의 총 매출은 " + totalSales + "원입니다.");
		} catch (SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
		   }
	}
	
	// 아이템 관리
	/**
	*  3. 모든 아이템 검색
	*  @author 김현지
	*/
	public static void selectItemAll() {
		try {
			List<ItemDTO> list = managerService.selectItemAll();
			ManagerSuccessView.selectItemPrint(list);
		} catch (SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
		 }
	}
	
	/**
	 *  4. 인기 아이템 검색(top3)
	 *  @author 김현지
	 */
	public static void selectItemTop3() {
		try {
			List<String> list = managerService.selectItemTop3();
			ManagerSuccessView.selectTop3ItemPrint(list);
		} catch (SearchWrongException e) {
			   FailView.errorMessage(e.getMessage());
		 }
	};
	
	/**
	 * 5. 아이템 추가
	 * @author 김현지
	 */
	public static void insertItem(ItemDTO itemDTO) {
		try {
			managerService.insertItem(itemDTO);
			SuccessView.messagePrint(itemDTO+" 아이템이 추가되었습니다.");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	/**
	 * 6. 아이템 이름으로 삭제
	 * @author 김현지
	 */
	public static void deleteItemByItemName(String itemName) {
		try {
			managerService.deleteItemByItemName(itemName);
			SuccessView.messagePrint(itemName+"아이스크림 메뉴를 삭제하였습니다.");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
	/**
	 * 7. 아이템 아이템번호로 선택한 후 수정(재고관리)
	 * @author 김현지
	 */
	public static void updateItemStock(ItemDTO itemDTO) {
		try {
			managerService.updateItemStock(itemDTO);
			SuccessView.messagePrint(itemDTO.getItemName()+ "아이스크림 재고를 " +itemDTO. getStock()+"개 추가하였습니다.");
		} catch (DMLException e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	
}
