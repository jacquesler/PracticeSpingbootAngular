package eCom.unitTest.Catalog;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import eCom.domain.cart.BasketItem;
import eCom.domain.cart.Catalog;
import eCom.domain.inventory.StockItem;
import eCom.factory.PriceFactory;
import eCom.factory.StockItemFactory;
import eCom.finance.Currency;
import eCom.finance.ExchangeRate;
import eCom.unitTest.fakes.FakeExchangeRates;
import eCom.unitTest.fakes.FakeStockItems;

public class CatalogTest {
	
	@Test
	public void TestBasketItemsAreBuiltCorrectly() throws Exception{
		// Arrange
		Catalog catalog = new Catalog(Currency.GBP, FakeStockItems.getStockItems(), FakeExchangeRates.getExchangeRates());
		
		// Act
		List<BasketItem> result = catalog.getBasketItems();
		
		// Assert
		List<BasketItem> basketItems = new ArrayList<>();
		StockItemFactory stockItemFactory = StockItemFactory.Instance;
		PriceFactory priceFactory = PriceFactory.Instance;
		ExchangeRate gbpUSD = new ExchangeRate(Currency.GBP, Currency.USD, 1.2);
		ExchangeRate gbpGbp = new ExchangeRate(Currency.GBP, Currency.GBP, 1);
		StockItem bananas = stockItemFactory.createStock("1", "Bananas", priceFactory.createPrice(0.5, Currency.USD), false, true);
		StockItem oranges = stockItemFactory.createStock("2", "Oranges", priceFactory.createPrice(1.0, Currency.GBP), false, true);
		basketItems.add(new BasketItem(bananas, gbpUSD, 0));
		basketItems.add(new BasketItem(oranges, gbpGbp, 0));
		
		Assert.assertArrayEquals(basketItems.toArray(), result.toArray());
	}
	
	
}
