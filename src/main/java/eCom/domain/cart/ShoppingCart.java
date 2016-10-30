package eCom.domain.cart;

import java.util.ArrayList;
import java.util.List;
import eCom.domain.order.BoughtItem;
import eCom.domain.order.Order;
import eCom.repository.CataglogRepository;

/*
 * Allows the user to add items to the shopping cart
 */
public class ShoppingCart {
	
	private List<BoughtItem> boughtItems = new ArrayList<>();
	private Catalog catalog;
	
	public ShoppingCart(CataglogRepository cr) throws Exception{
		catalog = cr.load();
	}
	
	public void AddToCart(List<BoughtItem> items){
		this.boughtItems.addAll(items);
	}
	
	public Order getOrder() throws Exception{
		return new Order(catalog.getBaseCurrency(), boughtItems, catalog.getBasketItems());
	}
	
	
}
