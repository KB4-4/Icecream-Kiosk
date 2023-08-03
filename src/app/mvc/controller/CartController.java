package app.mvc.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import app.mvc.dto.ItemDTO;
import app.mvc.service.ItemService;
import app.mvc.service.ItemServiceImpl;
import app.mvc.session.Session;
import app.mvc.view.FailView;
import app.mvc.view.SuccessView;

public class CartController {
	private static ItemService itemService = ItemServiceImpl.getInstance();
	
	//전체 상품 조회
	public static void showMenuList() {
		try {
			List<ItemDTO> list = itemService.showMenuList();
			SuccessView.printMenuList(list);
		} catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}

	// 장바구니 담기
	public static void putCart(int memberNo, int itemNo, int buyCnt) {
		try {
			// itemNo 상품 찾기
			ItemDTO item = itemService.itemsSelectByItemsId(itemNo);

			// 해당상품의 재고보다 구매수량이 많으면 SQLException
			if (item.getStock() < buyCnt) {
				throw new SQLException("재고량 부족으로 장바구니에 담을 수 없습니다.");
			}

			// 장바구니 생성
			Map<Integer, Integer> cart = Session.getInstance().getCart();

			// itemNo 수량
			Integer qut = cart.get(itemNo);

			// 장바구니 추가
			if (qut == null) {
				cart.put(itemNo, buyCnt);
			} else {
				qut += buyCnt;
				cart.put(itemNo, qut);
			}
			SuccessView.messagePrint("장바구니에 담았습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

	// 장바구니 보기
	public static void viewCart(int memberNo) {
		if (Session.getInstance().getMember_no() == memberNo) {
			Map<Integer, Integer> cart = Session.getInstance().getCart();
			if (cart == null) { // 장바구니가 없는 고객
				FailView.errorMessage("장바구니가 비었습니다.");
			} else {
				SuccessView.printViewCart(memberNo, cart);
			}
		}
	}

	//장바구니 수정
	public static void deleteCart(int itemNo, int cnt) {
		try {
			Map<Integer, Integer> cart = Session.getInstance().getCart();

			if (cart.isEmpty()) {
				FailView.errorMessage("장바구니가 비어있습니다.");
			} else {
				// cart.remove(itemNo);
				if (cart.containsKey(itemNo)) {
					int nowCnt = cart.get(itemNo);
					int resultCnt = nowCnt - cnt;
					if (resultCnt < 0) {
						System.out.println("현재수량보다 삭제할 수량이 많습니다.");
					} else if (resultCnt == 0) {
						cart.remove(itemNo);
						SuccessView.messagePrint("장바구니에서 상품을 삭제했습니다.");

					} else {
						cart.put(itemNo, resultCnt);
						SuccessView.messagePrint("장바구니에서 " + itemNo + "번을 " + cnt + "개를 삭제했습니다.");
					}
				}
			}
		} catch (Exception e) {
			// e.printStackTrace();
			FailView.errorMessage(e.getMessage());
		}
	}

}
