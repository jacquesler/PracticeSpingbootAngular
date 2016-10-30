package eCom.repository;

import java.util.List;

import eCom.factory.ExchangeRateFactory;
import eCom.finance.Currency;
import eCom.finance.ExchangeRate;
import eCom.utility.CollectorUtility;

public class CsvExchangeRateRepository implements ExchangeRateRepository{

	@Override
	public ExchangeRate load(String code) throws Exception {
		return loadAll().stream().filter((i) -> i.getBaseCurrency().getCurrenyCode().equalsIgnoreCase(code))
				.collect(CollectorUtility.singleItemCollector());
	}
	
	@Override
	public ExchangeRate load(Currency currency) throws Exception {
		return loadAll().stream().filter((i) -> i.getBaseCurrency().equals(currency))
				.collect(CollectorUtility.singleItemCollector());
	}

	@Override
	public List<ExchangeRate> loadAll() throws Exception {
		CsvCommandReader<ExchangeRate> csvCommandReader = new CsvCommandReader<>("ExchangeRate.csv", ExchangeRateFactory.Instance);
		return csvCommandReader.loadAll().getDomainList();
	}

}
