package app.mvc.view;
import app.mvc.controller.CartController;
import app.mvc.session.Session;

import java.util.Scanner;

public class MenuView {
    private static Scanner sc = new Scanner(System.in);

    public static void menu() {
        while(true) {
            Session session = Session.getInstance();
            //System.out.println(ss.getSet());

            //초기화면
            MenuView.printMenu();

            int menu = Integer.parseInt(sc.nextLine());
            switch(menu) {
                case 1 :
                    //MenuView.register(); // 가입
                    break;
                case 2 :
                    MenuView.login();// 로그인
                    break;

                case 9 :
                    System.exit(0);//종료
            }
        }

    }


    public static void printMenu() {
        System.out.println("=== IceCream Mall ===");
        System.out.println("1. 가입   |   2. 로그인   |  9. 종료");
    }


    public static void printUserMenu(int memberNo) {
        while(true) {
//            Session ss = Session.getInstance();
//            System.out.println(ss.getSet());

            System.out.println("-----" +memberNo+ " 로그인 중 -----");
            System.out.println(" 1.장바구니 보기 | 2.장바구니 추가 | 3.장바구니 수정 | 4.결제 | 5.종료 ");
            int menu =Integer.parseInt(sc.nextLine());
            switch(menu) {
                case 1 :
                    viewCart(memberNo);
                    break;
                case 2 :
                    MenuView.putCart(memberNo);//
                    break;
                case 3 :
                    //장바구니 수정 어디에 만들어야 할까?
                    break;
                case 4 :
                    //결제는 어디에 만들어야 할까?
                    //OrderController.selectOrdersByMemberNo(memberNo);
                    break;
                case 5 :
                    System.exit(0);
            }
        }

    }

    //로그인
    public static void login() {
        System.out.print("전화번호 : ");
        String phone = sc.nextLine();

        CustomerController.login(phone);
    }

    /**
     * 로그아웃
     * */
    public static void logout(int memberNo) {
//        Session session = new Session(userId);
//
//        SessionSet ss = SessionSet.getInstance();
//        ss.remove(session);
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
        //CartController.viewCart(id);



    }
}
