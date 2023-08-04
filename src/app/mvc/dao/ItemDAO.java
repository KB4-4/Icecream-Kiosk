package app.mvc.dao;

import app.mvc.dto.ItemDTO;
import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {

	/**
	 * 1. 아이스크림 메뉴 검색(메뉴판)
	 * 
	 * @author 장재은
	 * @return List 메뉴리스트
	 * @throws 메뉴 리스트가 없을때 ▶ SQLException
	 */
	List<ItemDTO> getItems() throws SQLException;

	/**
	 * 2. itemNo에 해당하는 정보 검색(장바구니 담기에 사용할 기능으로, 재고가 충분한지 확인)
	 * 
	 * @author 나경률
	 * @param itemId 상품 찾기
	 * @return ItemDTO 상품정보
	 * @throws 해당상품의 재고보다 구매수량이 많을때 ▶ SQLException
	 */
	ItemDTO itemsSelectByItemsId(int itemId) throws SQLException;

}
