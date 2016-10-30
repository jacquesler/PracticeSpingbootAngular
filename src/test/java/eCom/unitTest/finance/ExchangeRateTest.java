package eCom.unitTest.finance;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eCom.finance.Currency;
import eCom.finance.ExchangeRate;
import eCom.finance.Money;

public class ExchangeRateTest {

	private Currency baseCurrency;
	private Currency counterCurrency;
	
	@Before
	public void Setup(){
		baseCurrency = Currency.GBP;
		counterCurrency = Currency.USD;
	}
	
	@Test
	public void TestExchangeRateGivesOneWhenSameCurrency() throws Exception{
		// Arrange		
		ExchangeRate exchangeRate = new ExchangeRate(baseCurrency, counterCurrency, 0.5);
		Money gbpPrice = new Money(BigDecimal.valueOf(10.5), Currency.GBP);
		
		// Act
		Money price = exchangeRate.calculateBaseCurrencyPrice(gbpPrice);
		
		// Assert
		Assert.assertEquals(BigDecimal.valueOf(10.5).setScale(2), price.getAmount());
	}
	
	@Test
	public void TestExchangeRateWhenCounterCurrencyPassedThrough() throws Exception{
		// Arrange		
		ExchangeRate exchangeRate = new ExchangeRate(baseCurrency, counterCurrency, 2);
		Money usdPrice = new Money(BigDecimal.valueOf(20), Currency.USD);
		
		// Act
		Money price = exchangeRate.calculateBaseCurrencyPrice(usdPrice);
		
		// Assert
		Assert.assertEquals(BigDecimal.valueOf(10.0).setScale(2), price.getAmount());
	}
	
	@Test(expected=Exception.class)
	public void TestExceptionThrownWhenUnknownCurrencyPassedIn() throws Exception{
		// Arrange		
		ExchangeRate exchangeRate = new ExchangeRate(baseCurrency, counterCurrency, 0.5);
		Money zarPrice = new Money(BigDecimal.valueOf(20), Currency.ZAR);
		
		// Act
		exchangeRate.calculateBaseCurrencyPrice(zarPrice);
	}
}
