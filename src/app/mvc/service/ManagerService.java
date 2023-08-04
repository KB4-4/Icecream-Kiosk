package app.mvc.service;

import java.util.List;
import app.mvc.dto.ItemDTO;
import app.mvc.dto.OrderDTO;
import app.mvc.exception.DMLException;
import app.mvc.exception.SearchWrongException;

public interface ManagerService {
	/**
	 * 1. 모든 주문 검색
	 * 
	 * @author 김현지
	 * @return List 주문리스트
	 * @throws 주문 목록이 없을 때 ▶ SearchWrongException
	 */
	List<OrderDTO> selectOrderAll() throws SearchWrongException;

	/**
	 * 2. 기간별 주문 검색(매출액)
	 * 
	 * @author 김현지
	 * @param period ▶ 1.하루 2.일주일 3.한달 기준
	 * @return int 매출액
	 * @throws SQL조회에 문제가 발생할 때 ▶ SearchWrongException
	 */
	int selectTotalSalesByPeriod(int period) throws SearchWrongException;

	/**
	 * 3. 모든 메뉴 검색
	 * 
	 * @author 김현지
	 * @return List 메뉴리스트
	 * @throws 메뉴가 없을 때 ▶ SearchWrongException
	 */
	List<ItemDTO> selectItemAll() throws SearchWrongException;

	/**
	 * 4. 인기 메뉴 검색(TOP3)
	 * 
	 * @author 김현지
	 * @return List 메뉴명
	 * @throws 인기메뉴 정보가 없을 때 ▶ SearchWrongException
	 */
	List<String> selectItemTop3() throws SearchWrongException;

	/**
	 * 5. 메뉴 추가
	 * 
	 * @author 김현지
	 * @param itemDTO 추가할 메뉴정보
	 * @return int 추가성공여부
	 * @throws 메뉴가 추가되지 않았을 때 ▶ DMLException
	 */
	int insertItem(ItemDTO itemDTO) throws DMLException;

	/**
	 * 6. 메뉴 이름으로 삭제
	 * 
	 * @author 김현지
	 * @param itemName 메뉴이름
	 * @return int 삭제성공여부
	 * @throws 메뉴가 삭제되지 않았을 때 ▶ DMLException
	 */
	int deleteItemByItemName(String itemName) throws DMLException;

	/**
	 * 7. 메뉴 재고관리(메뉴 번호로 조회 후 수정)
	 * 
	 * @author 김현지
	 * @param itemDTO 수정할 아이템정보
	 * @return int 수정성공여부
	 * @throws 메뉴 재고가 수정되지 않았을 때 ▶ DMLException
	 */
	int updateItemStock(ItemDTO itemDTO) throws DMLException;

}
