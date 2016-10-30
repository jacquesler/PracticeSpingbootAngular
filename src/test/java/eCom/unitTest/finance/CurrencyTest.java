package eCom.unitTest.finance;

import org.junit.Assert;
import org.junit.Test;

import eCom.finance.Currency;


public class CurrencyTest {

	@Test
	public void TestCanGetCorrectCurrencyWithCode() throws Exception{
		// Assert
		Assert.assertEquals(Currency.USD, Currency.getCurrency("USD"));
		Assert.assertEquals(Currency.GBP, Currency.getCurrency("GBP"));
		Assert.assertEquals(Currency.ZAR, Currency.getCurrency("ZAR"));
	}
}
