package app.mvc.controller;

import app.mvc.dto.ItemDTO;
import app.mvc.service.ItemService;
import app.mvc.session.Session;
import app.mvc.view.FailView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CartController {
    private static ItemService itemService = new ItemService();

    public static void putCart(int memberNo, int itemNo, int quantity) {
        try {
            //itemNo 상품 찾기
            ItemDTO item = itemService.itemsSelectByItemsId(itemNo);

            //해당상품의 재고보다 구매수량이 많으면 SQLException
            if(item.getStock() < quantity) {
                throw new SQLException("재고량 부족으로 장바구니에 담을 수 없습니다.");
            }

            for( Integer key :Session.getCart().keySet()){
                Integer value = session.getCart().get(key);
            }

            System.out.println(Session.member_no);





            //세션에서 장바구니 찾기
            Map<ItemDTO, Integer> cart = (Map<ItemDTO, Integer>)session.getAttribute(); //상품, 수량 저장

            //장바구니가 없으면 장바구니 생성
            if(cart == null) {
                cart = new HashMap<>();
                session.setAttribute("cart", cart);
            }


            //장바구니에서 상품찾기
//            Integer oldQuantity = cart.get(item);
//            if(oldQuantity != null) { //장바구니에 이미 상품이 있다면
//                quantity += oldQuantity; //수량을 누적
//            }
//
//            cart.put(item, quantity); //장바구니에 상품 넣기
//            EndView.printMessage("장바구니에 담았습니다");
        } catch(Exception e) {
            e.printStackTrace();
            //FailView.errorMessage(e.getMessage());
        }
    }

    //map toString 재정의 : key=value 출력

    /**
     * 장바구니 보기
     * */
    public static void viewCart(String id) {
//        SessionSet ss = SessionSet.getInstance();
//        Session session = ss.get(id);

        Map<ItemDTO,Integer> cart = (Map<ItemDTO, Integer>) session.getAttribute("cart");
        if(cart == null ) { // 장바구니가 없는 고객
            FailView.errorMessage("장바구니가 비었습니다.");
        } else {
            //EndView.printViewCart(id , cart);
        }
    }

}



