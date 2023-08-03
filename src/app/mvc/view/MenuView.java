package app.mvc.view;

import java.util.Scanner;

import app.mvc.controller.LoginController;
import app.mvc.dto.MemberDTO;
import app.mvc.session.Session;

public class MenuView {
	static Scanner sc = new Scanner(System.in);

	public static void menu() {
		while (true) {
//			Session s = Session.getInstance();
//			System.out.println(s.get());

			System.out.println("=== Sweet Ice Club ===");
			System.out.println("1. 회원가입   |   2. 로그인 ");

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
			default:
				System.out.println("다시 입력해주세요");
			}
		}
	}

	public static void printUserMenu(String userId) {
		while (true) {
			Session s = Session.getInstance();

			System.out.println("-----" + userId + " 로그인 중 -----");
			System.out.println(" 1.주문추가 |  2.장바구니보기  |  3.장바구니수정  | 4.결제하기  |  5.종료하기 ");
			int menu = Integer.parseInt(sc.nextLine());
			switch (menu) {
			case 1:
				// 주문추가
				break;

			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				logout(userId);//
				return; // 함수를 빠져나가라.
			case 6:
				break;
			}
		}
	}

	//메소드 모음
	
	/**
	 * 회원가입
	 */
	public static void register() {
		System.out.println("====== 회원가입 진행 ======");
		System.out.println("====== 가입할 전화번호를 입력하세요 ======");
		String tempPhone = sc.nextLine();
		LoginController.inputMemberInsert(tempPhone);

	}
	
	/**
	 * 로그인
	 */
	public static void login() {
		System.out.println("로그인 할 전화번호 입력('-' 포함)");
		String tempPhone = sc.nextLine();
		LoginController.inputMemberLogin(tempPhone);
	}
	
	/**
	 * 로그아웃
	 * @param member_no
	 */
	public static void logout(String member_no) {
		Session.getInstance().setMember_no(0); //수정 필요!!!!!!!!
	}
}
