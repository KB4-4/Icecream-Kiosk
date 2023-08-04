package app.mvc.service;

import java.sql.SQLException;
import java.util.List;
import app.mvc.dto.ItemDTO;

public interface ItemService {

	/**
	 * 1. 아이스크림 메뉴(종류) 출력하기
	 * 
	 * @author 장재은
	 * @return List 메뉴리스트
	 * @throws 메뉴 리스트가 없을때 ▶ SQLException
	 */
	List<ItemDTO> showMenuList() throws SQLException;

	/**
	 * 2. itemNo에 해당하는 정보 검색(장바구니 담기에 사용할 기능으로, 재고가 충분한지 확인)
	 * 
	 * @author 나경률
	 * @param itemNo 상품 찾기
	 * @return ItemDTO 상품정보
	 * @throws 해당상품의 재고보다 구매수량이 많을때 ▶ SQLException
	 */
	ItemDTO itemsSelectByItemsId(int itemNo) throws SQLException;
}
