package app.mvc.dao;

import java.util.List;

import app.mvc.dto.ItemDTO;
import app.mvc.dto.MemberDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public interface ManagerDAO {
	// 주문 관리
	/**
	 * 1. 모든 주문 검색
	 * @author 김현지
	 */
	List<OrderDTO> selectOrderAll() throws SearchWrongException;
	
	/**
	 * 2. 기간별 주문 검색(매출액)
	 * 1. 하루
	 * 2. 일주일
	 * 3. 한달
	 * @author 김현지
	 */
	int selectTotalSalesByPeriod(int period) throws SearchWrongException;
	
	// 아이템 관리
	/**
	 *  3. 모든 아이템 검색
	 *  @author 김현지
	 */
	List<ItemDTO> selectItemAll() throws SearchWrongException;
	
	/**
	 *  4. 인기 아이템 검색(top3)
	 *  @author 김현지
	 */
	List<String> selectItemTop3() throws SearchWrongException;
	
	/**
	 * 5. 아이템 추가
	 * @author 김현지
	 */
	int insertItem(ItemDTO itemDTO) throws DMLException;

	/**
	 * 6. 아이템 이름으로 삭제
	 * @author 김현지
	 */
	int deleteItemByItemName(String itemName) throws DMLException;
	
	/**
	 * 7. 아이템 아이템번호로 선택한 후 수정(재고관리)
	 * @author 김현지
	 */
	int updateItemStock(ItemDTO itemDTO) throws DMLException;
	
	
}
