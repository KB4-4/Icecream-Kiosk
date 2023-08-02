package app.mvc.dto;

public class ItemDTO {
	private int itemNo; //품번
	private String itemName; //상품명
	private int price; //가격
	private int stock; //재고
	private String info; //상품 설명 
	
	public ItemDTO() {}
	
	public ItemDTO(int itemNo, String itemName, int price, int stock, String info) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
		this.info = info;
	}

	public int getItemNo() {
		return itemNo;
	}

	public void setItemNo(int itemNo) {
		this.itemNo = itemNo;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Item [상품번호=");
		builder.append(itemNo);
		builder.append(", 상품명=");
		builder.append(itemName);
		builder.append(", 가격=");
		builder.append(price);
		builder.append(", 구매가능수량=");
		builder.append(stock);
		builder.append(", 설명=");
		builder.append(info);
		builder.append("]");
		return builder.toString();
	}
}
