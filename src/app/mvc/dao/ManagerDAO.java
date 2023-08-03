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
	 */
	List<OrderDTO> selectOrderAll() throws SearchWrongException;
	
	/**
	 * 2. 기간별 주문 검색(매출액)
	 * 1. 하루
	 * 2. 일주일
	 * 3. 한달
	 */
	int selectTotalSalesByPeriod(int period) throws SearchWrongException;
	
	// 아이템 관리
	/**
	 *  3. 모든 아이템 검색
	 */
	List<ItemDTO> selectItemAll() throws SearchWrongException;
	
	/**
	 *  4. 인기 아이템 검색(top3)
	 */
	List<String> selectItemTop3() throws SearchWrongException;
	
	/**
	 * 5. 아이템 추가
	 */
	int insertItem(ItemDTO itemDTO) throws DMLException;

	/**
	 * 6. 아이템 이름으로 삭제
	 */
	int deleteItemByItemName(String itemName) throws DMLException;
	
	/**
	 * 7. 아이템 아이템번호로 선택한 후 수정(재고관리)
	 */
	int updateItemStock(ItemDTO itemDTO) throws DMLException;
	
	// 멤버 관리
	/**
	 * 8. 전체 멤버 검색
	 */
	List<MemberDTO> selectMemberAll() throws SearchWrongException;
	
	/**
	 * 9. 전화번호로 해당하는 멤버 검색
	 */
	MemberDTO selectMemberByPhone(String phone) throws SearchWrongException;
	
	/**
	 * 10. 멤버 추가
	 */
	int insertMember(MemberDTO memberdto) throws DMLException;
	
	/**
	 * 11. 전화번호로 해당하는 멤버 삭제
	 */
	int deleteMemberByPhone(String phone) throws DMLException;
	
	/**
	 * 12. 멤버 등급 수정
	 */
	int updateMemberGrade() throws DMLException;
}
