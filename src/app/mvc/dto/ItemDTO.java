package app.mvc.dto;

public class ItemDTO {
	private int itemNo; // 품번
	private String itemName; // 상품명
	private int price; // 가격
	private int stock; // 재고
	private String info; // 상품 설명

	public ItemDTO() {
	}

	public ItemDTO(int itemNo, String itemName, int price, int stock, String info) {
		super();
		this.itemNo = itemNo;
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
		this.info = info;
	}

	public ItemDTO(String itemName, int price, int stock, String info) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.stock = stock;
		this.info = info;
	}

	public ItemDTO(String itemName, int stock) {
		super();
		this.itemName = itemName;
		this.stock = stock;
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
//	[번호]     [가격]     [재고]      [메뉴명(설명)]
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
	    builder.append(String.format("%5s", itemNo));
	    builder.append(String.format("%10s", "₩" + price));
	    builder.append(String.format("%10s", stock));
	    builder.append(String.format("%25s", itemName + "(" + info + ")"));
	    return builder.toString();
	}
}
