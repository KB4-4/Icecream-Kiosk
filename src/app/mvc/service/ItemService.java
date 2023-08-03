package app.mvc.service;

import app.mvc.dao.ItemDAO;
import app.mvc.dao.ItemDAOImpl;
import app.mvc.dto.ItemDTO;
import app.mvc.exception.NotFoundException;

import java.sql.SQLException;
import java.util.List;

public class ItemService {
    ItemDAO itemDao = new ItemDAOImpl();
//
//
//    public List<ItemDTO> cartSelect() throws NotFoundException, SQLException{
//        List<ItemDTO> list = itemDao.cartSelect();
//        if(list.size() == 0) {
//            throw new NotFoundException("장바구니가 비었습니다.");
//        }
//        return list;
//    }

    //itemNo에 해당하는 item 검색
    public ItemDTO itemsSelectByItemsId(int itemNo) throws SQLException {
        ItemDTO item = itemDao.itemsSelectByItemsId(itemNo);
        if(item == null) {
            throw new SQLException(itemNo + " 현재 상품이 없습니다.");
        }
        return item;
    }
}
