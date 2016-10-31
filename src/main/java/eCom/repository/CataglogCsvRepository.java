package eCom.repository;

import java.util.Set;

import org.springframework.stereotype.Component;

import eCom.domain.cart.Catalog;
import eCom.domain.inventory.StockItem;
import eCom.finance.Currency;
import eCom.finance.ExchangeRate;

@Component
public class CataglogCsvRepository implements CataglogRepository {

	@Override
	public Catalog load() throws Exception {
		Set<ExchangeRate> exchangeRates = new CsvExchangeRateRepository().loadAll();
		Set<StockItem> stockItems = new CsvStockRepository().loadAll();
		return new Catalog(Currency.GBP, stockItems, exchangeRates);
	}

}
