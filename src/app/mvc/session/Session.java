package app.mvc.session;

import java.util.HashMap;
import java.util.Map;

public class Session {

    private static Session instance = new Session();

    private Session() {}
    public static Session getInstance(){
        return instance;
    }

    private int member_no;	// int member_no
    private Map<Integer,Integer> cart; //장바구니	// key= item_no, value = int 수량

    public Session(int  member_no) {
        this.member_no = member_no;
        cart = new HashMap<>();
    }
    public int getmember_no() {
        return member_no;
    }

    public void setmember_no(int member_no) {
        this.member_no = member_no;
    }

    //추가
    public void setAttribute(int item_no, int quantity) {//cart , Map<Goods, Integer>
        cart.put(item_no,quantity);
    }

    //조회(Map에 key에 해당하는 value 찾기)
    public Object getAttribute(int item_no) {//cart
        return cart.get(item_no);
    }

    //제거(장바구니를 비울대 사용한다)
    public void removeAttribute(int item_no) {//cart
        cart.remove(item_no);
    }

    public Map<Integer,Integer> getcart() {
        return cart;
    }

    public void setcart(Map<Integer,Integer> cart) {
        this.cart = cart;
    }


    @Override
    public String toString() {
        return "Session [member_no=" + member_no + ", cart=" + cart + "]"+"\n";
    }


//    @Override
//    public int hashCode() {
//        return member_no.hashCode();
//    }

    /**
     * 같은 객체라는 뜻은 hashCode가 같아야하고,
     * equlas의 결과가 true여야한다.
     *
     *  hash코드가 다르면 무조건 다른 객체
     *  hash코드가 같으면 같은 객체일수도, 다른 객체일수도 있다.
     * */
//    @Override
//    public boolean equals(Object obj) {
//        Session other = (Session) obj;
//        if(member_no.equals(other.member_no)) {
//            return true;
//        }else {
//            return false;
//        }
//
//    }
}
