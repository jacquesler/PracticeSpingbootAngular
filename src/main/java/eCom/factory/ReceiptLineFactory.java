package eCom.factory;


import eCom.domain.order.ReceiptItem;
import eCom.domain.cart.BasketItem;
import eCom.finance.Money;

public enum ReceiptLineFactory {
	Instance;
	
	public ReceiptItem createRecieptItem(BasketItem basketItem){
		return createRecieptItem(basketItem.getStockItem().getName(), basketItem.getPrice(), basketItem.getQuantity());		
	}
	
	public ReceiptItem createTotalItem(Money price){
		return new ReceiptItem("Total", price, 1);
	}

	public ReceiptItem createRecieptItem(String name, Money price, int quantity) {
		return new ReceiptItem(name, price, quantity);
	}
}
