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

	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public Map<Integer, Integer> getCart() {
		return cart;
	}
	public void setCart(Map<Integer, Integer> cart) {
		this.cart = cart;
	}
	public static void setInstance(Session instance) {
		Session.instance = instance;
	}

    
}
