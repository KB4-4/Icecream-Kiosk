package app.mvc.dto;

public class CartDTO {
	private int itemNo; // 품번
	private String itemName; // 상품명
	private int count; // 가격
	private int price; // 수량

	public CartDTO() {
	}

	public CartDTO(int itemNo, String itemName, int count, int price) {
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.price = count;
		this.count = price;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
