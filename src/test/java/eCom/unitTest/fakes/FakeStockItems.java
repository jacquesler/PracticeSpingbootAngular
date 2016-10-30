package eCom.unitTest.fakes;

import java.util.ArrayList;
import java.util.List;

import eCom.domain.inventory.StockItem;
import eCom.factory.PriceFactory;
import eCom.factory.StockItemFactory;
import eCom.finance.Currency;

public class FakeStockItems {

	public static List<StockItem> getStockItems() throws Exception{
		StockItemFactory stockItemFactory = StockItemFactory.Instance;
		PriceFactory priceFactory = PriceFactory.Instance;
		List<StockItem> stockItems = new ArrayList<>(5);
			
		StockItem bananas = stockItemFactory.createStock("1", "Bananas", priceFactory.createPrice(0.5, Currency.USD), false, true);
		StockItem oranges = stockItemFactory.createStock("2", "Oranges", priceFactory.createPrice(1.0, Currency.GBP), false, true);
	
		stockItems.add(bananas);
		stockItems.add(oranges);
		
		return stockItems;
	}
	
}
