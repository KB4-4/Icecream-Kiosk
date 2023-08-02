package app.mvc.dto;

public class OrderDetailDTO {
	private int detailNo; //주문 상세 아이디
	private int orderNo; //주문번호
	private int itemNo; //구매한 상품 번호
	private int qty; //구매 수량

	public OrderDetailDTO() {}
	
	public OrderDetailDTO(int detailNo, int orderNo, int itemNo, int qty) {
		super();
		this.detailNo = detailNo;
		this.orderNo = orderNo;
		this.itemNo = itemNo;
		this.qty = qty;
	}

	public int getDetailNo() {
		return detailNo;
	}

	public void setDetailNo(int detailNo) {
		this.detailNo = detailNo;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderDetailDTO [detailNo=");
		builder.append(detailNo);
		builder.append(", orderNo=");
		builder.append(orderNo);
		builder.append(", itemNo=");
		builder.append(itemNo);
		builder.append(", qty=");
		builder.append(qty);
		builder.append("]");
		return builder.toString();
	}
}
