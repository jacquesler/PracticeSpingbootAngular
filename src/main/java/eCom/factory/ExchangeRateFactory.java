package eCom.factory;

import eCom.finance.Currency;
import eCom.finance.ExchangeRate;

public enum ExchangeRateFactory implements DomainCsvFactory<ExchangeRate> {
	Instance;
	
	@Override
	public ExchangeRate createFromCsvLine(String[] input) throws Exception {
		Currency baseCurrency = Currency.getCurrency(input[1]);
		Currency counterCurrency = Currency.getCurrency(input[2]);
		double rate = Double.parseDouble(input[3]);
		return Create(baseCurrency, counterCurrency, rate);
	}
	
	public ExchangeRate Create(Currency baseCurrency, Currency counterCurrency, double rate){
		return new ExchangeRate(baseCurrency, counterCurrency, rate);
	}

}
