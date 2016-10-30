package eCom.factory;

import eCom.finance.Money;

import java.math.BigDecimal;

import eCom.finance.Currency;

public enum PriceFactory {
	Instance;
	
	public Money createPrice(double amount, String currencyCode) throws Exception{
		return createPrice(amount, Currency.getCurrency(currencyCode));
	}
	
	public Money createPrice(double amount, Currency currency) throws Exception{
		return new Money(BigDecimal.valueOf(amount), currency);
	}
}
