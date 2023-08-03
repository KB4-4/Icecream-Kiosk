package app.mvc.view;

import app.mvc.dto.ItemDTO;

import java.util.Map;

public class EndView {
    public static void printMessage(String message) {
        System.out.println(message);
    }
    public static void printViewCart(int member_no, Map<Integer,Integer> cart) {
        System.out.println("장바구니내용....");

        for (Integer key : cart.keySet()) {
            int itemNo = key;//상품번호
            int cnt = cart.get(key);//수량
            //int price = ;//상품가격
            System.out.println(itemNo + "번 : " + cnt + "개");
        }
    }
}
