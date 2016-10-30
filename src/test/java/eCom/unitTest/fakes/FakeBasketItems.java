package eCom.unitTest.fakes;

import java.util.ArrayList;
import java.util.List;

import eCom.domain.cart.BasketItem;
import eCom.domain.inventory.StockItem;
import eCom.factory.PriceFactory;
import eCom.factory.StockItemFactory;
import eCom.finance.Currency;
import eCom.finance.ExchangeRate;

public class FakeBasketItems {

	public static List<BasketItem> getBasketItems() throws Exception{
		StockItemFactory stockItemFactory = StockItemFactory.Instance;
		PriceFactory priceFactory = PriceFactory.Instance;
		List<BasketItem> basketItems = new ArrayList<>(5);
		
		ExchangeRate gbpUSD = new ExchangeRate(Currency.GBP, Currency.USD, 1.2);
		ExchangeRate gbpGbp = new ExchangeRate(Currency.GBP, Currency.GBP, 1);
		
		StockItem bananas = stockItemFactory.createStock("1", "Bananas", priceFactory.createPrice(0.5, Currency.USD), false, true);
		StockItem oranges = stockItemFactory.createStock("2", "Oranges", priceFactory.createPrice(1.0, Currency.GBP), false, true);
	
		basketItems.add(new BasketItem(bananas, gbpUSD, 0));
		basketItems.add(new BasketItem(oranges, gbpGbp, 0));
		
		return basketItems;
	}
	
	
}
