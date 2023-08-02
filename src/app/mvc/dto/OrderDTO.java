package app.mvc.dto;

public class OrderDTO {
	private int orderNo; //주문번호
	private int memberNo; //주문회원
	private String orderDate; //주문일시
	private int payment; //결제액
	
	public OrderDTO() {}
	
	public OrderDTO(int orderNo, int memberNo, String orderDate, int payment) {
		super();
		this.orderNo = orderNo;
		this.memberNo = memberNo;
		this.orderDate = orderDate;
		this.payment = payment;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("영수증 [주문번호=");
		builder.append(orderNo);
		builder.append(", 주문자=");
		builder.append(memberNo);
		builder.append(", 주문일시=");
		builder.append(orderDate);
		builder.append(", 총 결제 금액=");
		builder.append(payment);
		return builder.toString();
	}
	
	
}
