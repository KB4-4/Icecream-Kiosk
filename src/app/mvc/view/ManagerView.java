package app.mvc.view;

import java.util.Scanner;

import app.mvc.controller.ManagerController;
import app.mvc.dto.ItemDTO;

public class ManagerView {
	static Scanner sc = new Scanner(System.in);

	/**
	 * 관리자 메뉴
	 */

	public static void managerMenuChoice() {
		while(true) {
			System.out.println("=========================================================================");
			System.out.println("\n-----------------------------주문 관리----------------------------\n");
			System.out.println("       1. 모든 주문 검색     |     2. 기간별 주문 검색 (총 매출액)");
			System.out.println();

			System.out.println("----------------------------상품 관리----------------------------\n");
			System.out.println("    3. 모든 아이스크림 검색     |     4. 인기 아이스크림 검색 (top3)");
			System.out.println("  5. 아이스크림 추가  |  6. 아이스크림 삭제  |  7. 아이스크림 수정 (재고추가)\n");
			System.out.println("---------------------------관리자 모드 종료-------------------------\n");
			System.out.println("    8. 종료하기");
			System.out.println("\n------------------------------------------------------------------\n");
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
					break;
				case 4:
					ManagerController.selectItemTop3();
					break;
				case 5:
					insertIceCream();
					break;
				case 6:
					deleteIceCream();
					break;
				case 7:
					updateStock();
					break;
				case 8:
					System.out.println("관리자 모드 종료");
					MenuView.menu();
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
	 * 
	 * @author 김현지
	 */
	public static void searchTotalSales() {
		try {
			System.out.println(" -----------------총매출을 합산할 최근 기간을 골라주세요-------------------- ");
			System.out.println("|          1. 하루        |        2. 일주일        |       3. 한달         |");
			System.out.println(" ----------------------------------------------------------------------------\n");

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

	/**
	 * 아이스크림 등록
	 * 
	 */
	public static void insertIceCream() {
		System.out.println("아이스크림 이름을 입력하세요.");
		String itemName = sc.nextLine();

		System.out.println("재고를 입력하세요.");
		int stock = Integer.parseInt(sc.nextLine());

		System.out.println("아이스크림 맛을 입력하세요.");
		String info = sc.nextLine();

		ItemDTO itemDto = new ItemDTO(itemName, 3000, stock, info);
		ManagerController.insertItem(itemDto);

	}

	/**
	 * 아이스크림 삭제
	 * 
	 */
	public static void deleteIceCream() {
		System.out.println("삭제할 아이스크림 이름을 입력하세요.");
		String itemName = sc.nextLine();
		ManagerController.deleteItemByItemName(itemName);
	}

	/**
	 * 아이스크림 재고 관리
	 * 
	 */
	public static void updateStock() {
		System.out.println("재고를 추가할 아이스크림 이름을 입력하세요.");
		String itemName = sc.nextLine();

		System.out.println("추가할 재고량을 입력하세요.");
		int stock = Integer.parseInt(sc.nextLine());

		ItemDTO itemDto = new ItemDTO(itemName, stock);

		ManagerController.updateItemStock(itemDto);
	}

}