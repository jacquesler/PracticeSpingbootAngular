package eCom.unitTest.fakes;

import java.util.ArrayList;
import java.util.List;

import eCom.finance.Currency;
import eCom.finance.ExchangeRate;

public class FakeExchangeRates {

	public static List<ExchangeRate> getExchangeRates(){
		ExchangeRate gbpUSD = new ExchangeRate(Currency.GBP, Currency.USD, 1.2);
		List<ExchangeRate> rates=  new ArrayList<>(1);
		rates.add(gbpUSD);		
		return rates;
		
	}
}
