package eCom.domain.inventory;

import eCom.finance.Money;

/*
 * Represents the data structure of the stock held and the price paid. May be in different currencies
 */
public final class StockItem{

	private final String id;
	private final String name;
	private final Money price;
	private final boolean onSpecial;
	private final boolean hasStock;
	
	public StockItem(String id, String name, Money price, boolean onSpecial, boolean hasStock){
		this.id = id;
		this.name = name;
		this.price = price;
		this.onSpecial = onSpecial;
		this.hasStock = hasStock;
	}	

	public String getName() {
		return name;
	}

	public Money getPrice() {
		return price;
	}

	public String getId() {
		return id;
	}

	public boolean isOnSpecial() {
		return onSpecial;
	}

	public boolean isHasStock() {
		return hasStock;
	}
	
}
