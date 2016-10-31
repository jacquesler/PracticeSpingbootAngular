package eCom.domain.cart;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import eCom.domain.order.BoughtItem;
import eCom.domain.order.Order;
import eCom.repository.CataglogRepository;
import eCom.validation.IllegalBasketOperation;
import eCom.validation.Validate;

/*
 * Allows the user to add items to the shopping cart
 */
public final class ShoppingCart {
	
	private List<BoughtItem> boughtItems = new ArrayList<>();
	private final Catalog catalog;
	
	public ShoppingCart(Catalog catalog) throws Exception{
		this.catalog = catalog;
	}
	
	public void AddToCart(List<BoughtItem> items){
		ValidateCart(items);
		this.boughtItems.addAll(items);
	}
	
	private void ValidateCart(List<BoughtItem> items){
		ValidItemsBougt(items);
		ValidQuantityBought(items);
	}
	
	private void ValidItemsBougt(List<BoughtItem> items){
		List<String> boughtItems = items.stream().map(e -> e.getId()).collect(Collectors.toList());
		List<String> availableItems = catalog.getBasketItems().stream().map(e -> e.getStockItem().getId()).collect(Collectors.toList());
		
		for(String boughtItemsId : boughtItems){
			Validate.when(!availableItems.contains(boughtItemsId))
			.throwIllegalBetException(String.format("A product that is not available has tried to be bought"));			
		}
	}
	
	private void ValidQuantityBought(List<BoughtItem> items){
		items.forEach(e -> {
			Validate.when(e.getQuantity() < 0).throwIllegalBetException(String.format("All items must have quantities be zero or greater"));
		});
	}
	
	public Order getOrder() throws Exception{
		return new Order(catalog.getBaseCurrency(), boughtItems, catalog.getBasketItems());
	}
}
