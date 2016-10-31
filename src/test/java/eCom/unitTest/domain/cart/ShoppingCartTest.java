package eCom.unitTest.domain.cart;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eCom.domain.cart.BasketItem;
import eCom.domain.cart.Catalog;
import eCom.domain.cart.ShoppingCart;
import eCom.domain.order.BoughtItem;
import eCom.domain.order.Order;
import eCom.factory.PriceFactory;
import eCom.factory.ReceiptLineFactory;
import eCom.finance.Currency;
import eCom.unitTest.fakes.FakeBasketItems;
import eCom.unitTest.fakes.FakeBoughtItems;
import eCom.unitTest.fakes.FakeExchangeRates;
import eCom.unitTest.fakes.FakeStockItems;
import eCom.validation.IllegalBasketOperation;

public class ShoppingCartTest {

	private Catalog catalog;
	
	@Before
	public void setUp() throws Exception {
		catalog = new Catalog(Currency.GBP, FakeStockItems.getStockItems(), FakeExchangeRates.getExchangeRates());
	}	
	
	@Test(expected=IllegalBasketOperation.class)
	public void TestIllegalShoppingBasketExcpetionThrownWhenItemNotInList() throws Exception{
		// Arrange 
		List<BoughtItem> boughtItems = new ArrayList<>(1);
		boughtItems.add(new BoughtItem("10", 10));
		
		// Act
		ShoppingCart cart = new ShoppingCart(catalog);
		cart.AddToCart(boughtItems);		
	}
	
	@Test(expected=IllegalBasketOperation.class)
	public void TestIllegalShoppingBasketExcpetionThrownWhenItemItemQuantityIsBelowZero() throws Exception{
		// Arrange 
		List<BoughtItem> boughtItems = new ArrayList<>(1);
		boughtItems.add(new BoughtItem("2", -1));
		
		// Act
		ShoppingCart cart = new ShoppingCart(catalog);
		cart.AddToCart(boughtItems);
		
	}
}
