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
			System.out.println("  1. 모든 주문 검색   ");
			System.out.println("  2. 기간별 주문 검색(총 매출액)");
			System.out.println("  3. 모든 아이템 검색");
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
			
			ManagerController.selectTotalSalesByPeriod(period);
		} catch (NumberFormatException e) {
			System.out.println("1, 2, 3 중에서 골라주세요.");
			searchTotalSales();
		}
	}
	
	
	
}