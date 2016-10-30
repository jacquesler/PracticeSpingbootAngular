package eCom.domain.order;

import eCom.finance.Money;

/*
 * Represents individual line in order
 */

public final class ReceiptItem {

	private final String name;
	private final Money price;
	private final int quantity;
	
	public ReceiptItem(String name, Money price, int quantity){
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getQuantity(){
		return this.quantity;
	}
	
	public Money getPrice(){
		return this.price;
	}
	
	public char getSymbol(){
		return this.price.getCurrency().getSymbol();
	}
	
	public double getTotal(){
		return price.Mulitply(quantity).getAmount().doubleValue();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + quantity;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReceiptItem other = (ReceiptItem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}
	
	
}
