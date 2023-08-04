package app.mvc.dao;

import app.mvc.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
	/**
	 * 메뉴 출력하기
	 * @return
	 * @throws Exception
	 */
	List<ItemDTO> getItems() throws SQLException;
	
	/**
	 * goodsId에 해당하는 정보 검색
	 * @param itemId
	 * @return
	 * @throws SQLException
	 */
	ItemDTO itemsSelectByItemsId(int itemId) throws SQLException;
	
	
}
