package eCom.unitTest.fakes;

import java.util.HashSet;
import java.util.Set;

import eCom.finance.Currency;
import eCom.finance.ExchangeRate;

public class FakeExchangeRates {

	public static Set<ExchangeRate> getExchangeRates(){
		ExchangeRate gbpUSD = new ExchangeRate(Currency.GBP, Currency.USD, 1.2);
		Set<ExchangeRate> rates=  new HashSet<>(1);
		rates.add(gbpUSD);		
		return rates;
		
	}
}
