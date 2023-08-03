package app.mvc.dto;

public class ReceiptDTO {
	
	private int orderNo; // 주문번호
	private String orderDate; // 주문일시 
	private int point; //잔여포인트
	private int payment; // 결제액
	
	public ReceiptDTO() {}

	public ReceiptDTO(int orderNo, String orderDate, int point, int payment) {
		super();
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.point = point;
		this.payment = payment;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
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
		builder.append("ReceiptDTO [orderNo=");
		builder.append(orderNo);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", point=");
		builder.append(point);
		builder.append(", payment=");
		builder.append(payment);
		builder.append("]");
		return builder.toString();
	};
	
		

}
