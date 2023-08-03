package app.mvc.view;
import app.mvc.controller.CartController;
import app.mvc.controller.LoginController;
import app.mvc.session.Session;
import app.mvc.controller.CartController;

import java.util.HashMap;
import java.util.Scanner;

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


    public static void printUserMenu(int memberNo) {
        while(true) {
//            Session ss = Session.getInstance();
//            System.out.println(ss.getSet());
			if (Session.getInstance().getMember_no() == memberNo) {

				System.out.println("-----" + memberNo + " 로그인 중 -----");
				System.out.println(" 1.장바구니 보기 | 2.장바구니 추가 | 3.장바구니 수정 | 4.결제 | 5.종료 ");
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
						//결제는 어디에 만들어야 할까?
						//OrderController.selectOrdersByMemberNo(memberNo);
						break;
					case 5:
						System.exit(0);
				}
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
		Session.getInstance().setCart(new HashMap<>());
	}

//    /**
//     * 주문하기
//     * */
    public static void printInputOrder(String userId) {
//        System.out.print("주문상품번호 : ");
//        String goodsId = sc.nextLine();
//
//        System.out.print("주문수량 : ");
//        int qty = Integer.parseInt(sc.nextLine());
//
//        Orders orders = new Orders(0, null, userId, address, 0);
//        OrderLine orderLine = new OrderLine(0, 0, goodsId, 0, qty, 0);
//
//        orders.getOrderLineList().add(orderLine);
//
//        OrderController.insertOrders(orders);
    }

    /**
     * 장바구니 담기
     * */
    public static void putCart(int memberNo) {
        System.out.println("--장바구니 담기 작업 --");
        System.out.print("상품번호 : ");
        int itemNo = Integer.parseInt(sc.nextLine());
        System.out.print("수량 : ");
        int qty = Integer.parseInt(sc.nextLine());

        CartController.putCart(memberNo,itemNo,qty);


    }

    /**
     * 장바구니 보기
     * */
    public static void viewCart(int memberNo) {
        CartController.viewCart(memberNo);
    }

	/**
	 * 장바구니 삭제
	 */
	public static void deleteCart(int memberNo) {
		System.out.println("--장바구니 삭제 작업 --");
		System.out.print("상품번호 : ");
		int itemNo = Integer.parseInt(sc.nextLine());
		System.out.print("수량 : ");
		int cnt = Integer.parseInt(sc.nextLine());
		CartController.deleteCart(itemNo, cnt);
	}
}
