package eCom.domain.cart;

import eCom.domain.inventory.StockItem;
import eCom.finance.ExchangeRate;
import eCom.finance.Money;
/*
 * Represents the individual items which can be bought by the user
 */
public final class BasketItem implements Comparable<BasketItem>{

	private StockItem stockItem;
	private ExchangeRate exchangeRate;
	private int quantity;
	public BasketItem(StockItem stockItem, ExchangeRate exchangeRate, int quantity){
		super();
		this.stockItem = stockItem;
		this.exchangeRate = exchangeRate;
		this.quantity = quantity;
	}

	public StockItem getStockItem() {
		return stockItem;
	}
	
	public Money getPrice() {
		return exchangeRate.calculateBaseCurrencyPrice(stockItem.getPrice());
	}
	
	public char getCurrencySymbol(){
		return exchangeRate.getBaseCurrency().getSymbol();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setStockItem(StockItem stockItem) {
		this.stockItem = stockItem;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((stockItem == null) ? 0 : stockItem.hashCode());
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
		BasketItem other = (BasketItem) obj;
		if (stockItem == null) {
			if (other.stockItem != null)
				return false;
		} else if (!stockItem.equals(other.stockItem))
			return false;
		return true;
	}

	@Override
	public int compareTo(BasketItem o) {
		return stockItem.compareTo(o.stockItem);
	}

	
	
	
}
