package app.mvc.view;

import java.util.Scanner;

import app.mvc.controller.ManagerController;

public class ManagerView {
	static Scanner sc =new Scanner(System.in);

	/**
	 * 관리자 메뉴
	 */

	public static void managerMenuChoice() {
		while(true) {
			System.out.println("\n----------------------------------------");
			System.out.println("  *** 주문 ***");
			System.out.println("    1. 모든 주문 검색   ");
			System.out.println("    2. 기간별 주문 검색(총 매출액)");
			System.out.println();
			System.out.println("  *** 아이스크림 ***");
			System.out.println("    3. 모든 아이스크림 검색");
			System.out.println("    4. 인기 아이스크림 검색(top3)");
			System.out.println("    5. 아이스크림 추가");
			System.out.println("    6. 아이스크림 삭제");
			System.out.println("    7. 아이스크림 재고관리)");
			System.out.println();
			System.out.println("  *** 멤버 ***");
			System.out.println("    8. 전체 멤버 검색");
			System.out.println("    9. 특정 멤버 검색");
			System.out.println("    10. 멤버 추가");
			System.out.println("    11. 멤버 삭제");
			System.out.println("    12. 전체 멤버 등급 갱신");
			System.out.println("\n----------------------------------------");
			try {
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					ManagerController.selectOrderAll();
					break;
				case 2:
					searchTotalSales();
					break;
				case 3:
					ManagerController.selectItemAll();
				default:
					System.out.println("잘못 입력했습니다. 다시 입력해주세요.");
				}
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력 가능합니다.");
			}
		} // while문

	} // managerMenuChoice()
	
	/**
	 * 매출액 검색
	 */
	public static void searchTotalSales() {
		try {
			System.out.println("총매출을 합산할 최근 기간을 골라주세요 \n");
			System.out.println("1. 하루");
			System.out.println("2. 일주일");
			System.out.println("3. 한달");
			int period = Integer.parseInt(sc.nextLine());
			if (!(period == 1 || period == 2 || period == 3)) {
				System.out.println("1, 2, 3 중에서 골라주세요.\n");
				searchTotalSales();
			}
			
			ManagerController.selectTotalSalesByPeriod(period);
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력 가능합니다.");
			searchTotalSales();
		}
	}
	
	
	
}