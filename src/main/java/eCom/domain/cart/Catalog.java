package eCom.domain.cart;

/*
 * Represents the all items that are for sale in converted all to a base currency
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import eCom.domain.inventory.StockItem;
import eCom.finance.Currency;
import eCom.finance.ExchangeRate;
import jersey.repackaged.com.google.common.collect.UnmodifiableListIterator;

public final class Catalog {

	private final Currency baseCurrency;
	private final List<BasketItem> basketItems;
	private final List<ExchangeRate> defaultExchangeRate;
	
	public Catalog(Currency baseCurrency, Set<StockItem> stockItems, Set<ExchangeRate> exchangeRates) throws Exception {
		super();
		this.baseCurrency = baseCurrency;
		this.defaultExchangeRate = getDefault();
		this.basketItems = buildBasketItems(stockItems,  mapExchangeRates(exchangeRates));
	}
	
	private List<BasketItem> buildBasketItems(Set<StockItem> stockItems,
			Map<Currency, List<ExchangeRate>> exchangeRates) throws Exception{
		
		List<BasketItem> basketItems = new ArrayList<>();
		for (StockItem stockItem : stockItems) {
			basketItems.add(getBasketItem(stockItem, exchangeRates, 0));
		}
		
		return basketItems;
	}
	
	private BasketItem getBasketItem(StockItem stockItem, Map<Currency, List<ExchangeRate>> exchangeRates, int i){
		return new BasketItem(stockItem, 
				exchangeRates.getOrDefault(stockItem.getPrice().getCurrency(), defaultExchangeRate).get(0),
				0);
	}

	private List<ExchangeRate> getDefault(){
		List<ExchangeRate> exchangeRates = new ArrayList<>();
		exchangeRates.add(ExchangeRate.DefaultExchangeRate(baseCurrency));
		return exchangeRates;
	}
	
	private Map<Currency, List<ExchangeRate>> mapExchangeRates(Set<ExchangeRate> rates){
		return rates.stream()
				.collect(Collectors.groupingBy(e -> e.getCounterCurrency()));
	}
	
	public List<BasketItem> getBasketItems() {
		Collections.sort(basketItems);
		return Collections.unmodifiableList(basketItems);
	}
	
	public Currency getBaseCurrency(){
		return baseCurrency;
	}
}
