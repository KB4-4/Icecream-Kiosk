package app.mvc.controller;

import app.mvc.dto.ItemDTO;
import app.mvc.dto.MemberDTO;
import exception.SearchWrongException;

public class ManagerController {
	/**
	 * 1. 모든 주문 검색
	 */
	public static void selectOrderAll() {}
	
	/**
	 * 2. 기간별 주문 검색(매출액)
	 * 1. 하루
	 * 2. 일주일
	 * 3. 한달
	 */
	public static void selectTotalSalesByPeriod(int period) {}
	
	// 아이템 관리
	/**
	*  3. 모든 아이템 검색
	*/
	public static void selectItemAll() {}
	
	/**
	 *  4. 인기 아이템 검색(top3)
	 */
	public static void selectItemTop3() {};
	
	/**
	 * 5. 아이템 추가
	 */
	public static void insertItem(ItemDTO itemDTO) {}
	
	/**
	 * 6. 아이템 이름으로 삭제
	 */
	public static void deleteItemByItemName(String itemName) {}
	
	/**
	 * 7. 아이템 아이템번호로 선택한 후 수정(재고관리)
	 */
	public static void updateItemStock(ItemDTO itemDTO) {}
	
	// 멤버 관리
	/**
	* 8. 전체 멤버 검색
	 */
	public static void selectMemberAll() {}
	
	/**
	 * 9. 전화번호로 해당하는 멤버 검색
	 */
	public static void selectMemberByPhone(String phone) {}
	
	/**
	 * 10. 멤버 추가
	 */
	public static void insertMember(MemberDTO memberdto) {}
	
	/**
	 * 11. 전화번호로 해당하는 멤버 삭제
	 */
	public static void deleteMemberByPhone(String phone) {}
	
	/**
	 * 12. 멤버 등급 수정
	 */
	public static void updateMemberGrade() {}
	
	
}
