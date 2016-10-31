package eCom.domain.order;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import eCom.domain.cart.BasketItem;
import eCom.factory.PriceFactory;
import eCom.factory.ReceiptLineFactory;
import eCom.finance.Currency;
import eCom.finance.Money;
/*
 * Represents items that have been bought and builds up the receipt lines
 */

public final class Order {

	private final List<ReceiptItem> recieptItems;	
	private final ReceiptLineFactory receiptLineFactory = ReceiptLineFactory.Instance;
	private final Currency baseCurrency;
	
	public Order(Currency baseCurrency, List<BoughtItem> boughtItems, List<BasketItem> basketItems) throws Exception{
		this.baseCurrency = baseCurrency;
		this.recieptItems = getReceiptLines(boughtItems, basketItems);
	}
	
	public List<ReceiptItem> getRecieptItems() throws Exception{
		addTotalLine();
		Collections.sort(recieptItems);
		return Collections.unmodifiableList(recieptItems);
	}
	
	private List<ReceiptItem> getReceiptLines(List<BoughtItem> boughtItems, List<BasketItem> basketItems){
		return basketItems.stream()
				.flatMap(s1 -> boughtItems.stream()
				.filter(s2 -> s1.getStockItem().getId().equals(s2.getId()))
				.map(v2 -> receiptItemTuple(s1, v2))).collect(Collectors.toList());
	}
	
	private ReceiptItem receiptItemTuple(BasketItem basketItem, BoughtItem boughtItem) {
		basketItem.setQuantity(boughtItem.getQuantity());		
		return receiptLineFactory.createRecieptItem(basketItem);
		
	}
	
	private void addTotalLine() throws Exception{
		Money price = PriceFactory.Instance.createPrice(getTotal(), baseCurrency);
		ReceiptItem totalItem = receiptLineFactory.createTotalItem(price);
		recieptItems.add(totalItem);
	}
	
	private double getTotal(){	
		double total = recieptItems.stream().mapToDouble(ReceiptItem::getTotal).sum();	
		return 	total;		
	}
}
