package app.mvc.dao;

import app.mvc.dto.ItemDTO;

import java.sql.SQLException;
import java.util.List;

public interface ItemDAO {
//    /**
//     * 전체 상품
//     * */
//    List<ItemDTO> cartSelect() throws SQLException;

    /**
     * goodsId에 해당하는 정보 검색
     * */
    ItemDTO itemsSelectByItemsId(int itemId) throws SQLException;
}
