package app.mvc.view;

import java.util.HashMap;
import java.util.Scanner;

import app.mvc.controller.CartController;
import app.mvc.controller.LoginController;
import app.mvc.controller.PaymentController;
import app.mvc.session.Session;

public class MenuView {
	static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
			System.out.println("                                                                                                                                     \r\n"
					+ "                                                                                                                                     \r\n"
					+ "  /$$$$$$  /$$      /$$ /$$$$$$$$ /$$$$$$$$ /$$$$$$$$       /$$$$$$  /$$$$$$  /$$$$$$$$        /$$$$$$  /$$       /$$   /$$ /$$$$$$$ \r\n"
					+ " /$$__  $$| $$  /$ | $$| $$_____/| $$_____/|__  $$__/      |_  $$_/ /$$__  $$| $$_____/       /$$__  $$| $$      | $$  | $$| $$__  $$\r\n"
					+ "| $$  \\__/| $$ /$$$| $$| $$      | $$         | $$           | $$  | $$  \\__/| $$            | $$  \\__/| $$      | $$  | $$| $$  \\ $$\r\n"
					+ "|  $$$$$$ | $$/$$ $$ $$| $$$$$   | $$$$$      | $$           | $$  | $$      | $$$$$         | $$      | $$      | $$  | $$| $$$$$$$ \r\n"
					+ " \\____  $$| $$$$_  $$$$| $$__/   | $$__/      | $$           | $$  | $$      | $$__/         | $$      | $$      | $$  | $$| $$__  $$\r\n"
					+ " /$$  \\ $$| $$$/ \\  $$$| $$      | $$         | $$           | $$  | $$    $$| $$            | $$    $$| $$      | $$  | $$| $$  \\ $$\r\n"
					+ "|  $$$$$$/| $$/   \\  $$| $$$$$$$$| $$$$$$$$   | $$          /$$$$$$|  $$$$$$/| $$$$$$$$      |  $$$$$$/| $$$$$$$$|  $$$$$$/| $$$$$$$/\r\n"
					+ " \\______/ |__/     \\__/|________/|________/   |__/         |______/ \\______/ |________/       \\______/ |________/ \\______/ |_______/ \r\n"
					+ "                                                                                                                                     \r\n"
					+ "                                                                                                                                     \r\n"
					+ "                                                                                                                                     ");
			System.out.println("======================1. 회원가입   |   2. 로그인======================== ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				MenuView.register(); // 회원가입
				break;
			case 2:
				MenuView.login(); // 로그인
				break;
			case 100:
				System.out.println("종료");
				System.exit(0);
			case 500:
				MenuView.manageKiosk();
				break;
			default:
				System.out.println("다시 입력해주세요");
			}
		}
	}

	public static void printUserMenu(int memberNo) {
		if (Session.getInstance().getMember_no() == memberNo) {
			System.out.println("\n\n============================회원#" + memberNo + " 주문 시작============================\n");
			StringBuilder builder = new StringBuilder();
		    builder.append(String.format("%4s", "번호"));
		    builder.append(String.format("%7s", "가격"));
		    builder.append(String.format("%10s", "재고"));
		    builder.append(String.format("%25s", "메뉴명(설명)"));
			System.out.println(builder);
			CartController.showMenuList(); //메뉴 출력
			while (true) {
				System.out.println(" ------------------------------------------------------------------------");
				System.out.println("| 1.장바구니 보기 | 2.장바구니 추가 | 3.장바구니 수정 | 4.결제 | 5.종료  |");
				System.out.println(" ------------------------------------------------------------------------");
				int menu = Integer.parseInt(sc.nextLine());
				switch (menu) {
				case 1:
					viewCart(memberNo);
					break;
				case 2:
					MenuView.putCart(memberNo);
					break;
				case 3:
					MenuView.deleteCart(memberNo);
					break;
				case 4:
					MenuView.orderPayment();
					break;
				case 5:
					MenuView.logout(memberNo);
					break;
				default:
					System.out.println("다시 입력해주세요");
				}
			}
		}

	}

	// 메소드 모음

	/**
	 * 회원가입
	 */
	public static void register() {
		System.out.println("============================= 회원가입 진행 =============================");
		System.out.println("===================== 가입할 전화번호를 입력하세요 ======================");
		String tempPhone = sc.nextLine();
		LoginController.inputMemberInsert(tempPhone);

	}

	/**
	 * 로그인
	 */
	public static void login() {
		
		System.out.println("================================ 로그인 =================================");
		System.out.println(" 로그인 할 전화번호 입력('-' 포함):");
		String tempPhone = sc.nextLine();
		System.out.println("=========================================================================");
		LoginController.inputMemberLogin(tempPhone);
	}

	/**
	 * 로그아웃 → session에 저장된 값 초기화 후 메인화면으로 이동
	 * 
	 * @param member_no
	 */
	public static void logout(int member_no) {
		Session.getInstance().setMember_no(0);
		Session.getInstance().setCart(new HashMap<>());

		System.out.println("로그아웃 중... 잠시후 메인화면으로 이동됩니다");
		MenuView.menu();
	}

	/**
	 * 장바구니 담기
	 */
	public static void putCart(int memberNo) {
		System.out.println("\n========================= 장바구니 담기 작업 ============================\n");
		System.out.print("상품번호 : ");
		int itemNo = Integer.parseInt(sc.nextLine());
		System.out.print("수량 : ");
		int qty = Integer.parseInt(sc.nextLine());

		CartController.putCart(memberNo, itemNo, qty);

	}

	/**
	 * 장바구니 보기
	 */
	public static void viewCart(int memberNo) {
		CartController.viewCart(memberNo);
	}

	/**
	 * 장바구니 수정
	 */
	public static void deleteCart(int memberNo) {
		System.out.println("\n========================= 장바구니 수정 작업 ============================\n");
		System.out.print("상품번호 : ");
		int itemNo = Integer.parseInt(sc.nextLine());
		System.out.print("삭제할 수량 : ");
		int cnt = Integer.parseInt(sc.nextLine());
		CartController.deleteCart(itemNo, cnt);
	}

	/**
	 * 결제하기
	 */
	public static void orderPayment() {
		if(Session.getInstance().getCart().isEmpty()) {
			System.out.println("장바구니가 비어있습니다.");
		} else {
			System.out.println("\n======================결제하실 수단을 선택해주세요.======================\n");
			System.out.println("1. 카드결제   |   2. 포인트결제(단, 보유 포인트가 구매 금액보다 클 때만 포인트 사용 가능합니다)");
			int selectPayment = Integer.parseInt(sc.nextLine());
			PaymentController.updateMemberAddPoint(selectPayment);
		}
	}

	public static void manageKiosk() {
		ManagerView.managerMenuChoice();
	}
}
