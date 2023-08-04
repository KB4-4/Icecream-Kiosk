package app.mvc.service;

import java.sql.SQLException;
import java.util.List;
import app.mvc.dao.ItemDAO;
import app.mvc.dao.ItemDAOImpl;
import app.mvc.dto.ItemDTO;

public class ItemServiceImpl implements ItemService {

	private ItemServiceImpl() {
	};

	private static ItemService instance = new ItemServiceImpl();

	public static ItemService getInstance() {
		return instance;
	}

	private ItemDAO itemDAO = ItemDAOImpl.getInstance();

	/**
	 * 메뉴 리스트 검색
	 */
	@Override
	public List<ItemDTO> showMenuList() throws SQLException {
		List<ItemDTO> list = itemDAO.getItems();
		if (list.size() == 0) {
			throw new SQLException("현재 주문 가능한 상품이 없습니다.");
		}
		return list;
	}

	/**
	 * itemNo에 해당하는 item 검색
	 */
	@Override
	public ItemDTO itemsSelectByItemsId(int itemNo) throws SQLException {
		ItemDTO item = itemDAO.itemsSelectByItemsId(itemNo);
		if (item == null) {
			throw new SQLException(itemNo + " 현재 상품이 없습니다.");
		}
		return item;
	}
}
