package app.mvc.service;

import java.sql.SQLException;
import java.util.List;

import app.mvc.dto.ItemDTO;
import app.mvc.exception.NotFoundException;

public interface ItemService {
	/**
	 * 모든 메뉴 검색
	 * @return
	 * @throws NotFoundException
	 * @throws SQLException
	 */
	List<ItemDTO> showMenuList() throws NotFoundException, SQLException;
	
	/**
	 * 주문 추가시 상품 조회
	 * @param itemNo
	 * @return
	 * @throws SQLException
	 */
	ItemDTO itemsSelectByItemsId(int itemNo) throws SQLException;
}
