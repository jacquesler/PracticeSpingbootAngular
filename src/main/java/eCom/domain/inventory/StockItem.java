package eCom.domain.inventory;

import eCom.finance.Money;

/*
 * Represents the data structure of the stock held and the price paid. May be in different currencies
 */
public final class StockItem implements Comparable<StockItem>{

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		StockItem other = (StockItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int compareTo(StockItem o) {
		return name.compareTo(o.name);
	}
	
}
