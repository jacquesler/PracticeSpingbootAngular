package eCom.unitTest.domain.cart;

import org.junit.Assert;
import org.junit.Test;

import eCom.domain.cart.BasketItem;
import eCom.domain.inventory.StockItem;
import eCom.factory.ExchangeRateFactory;
import eCom.factory.PriceFactory;
import eCom.factory.StockItemFactory;
import eCom.finance.Currency;
import eCom.finance.ExchangeRate;
import eCom.finance.Money;

public class BasketItemTest {

	@Test
	public void TestPriceIsCorrectGivenExchangeRate() throws Exception{
		// Arrange
		Money price = PriceFactory.Instance.createPrice(20.0, Currency.USD);
		StockItem stockItem = StockItemFactory.Instance.createStock("1", "Test Stock", price, false, true);
		ExchangeRate exchangeRate = ExchangeRateFactory.Instance.Create(Currency.GBP, Currency.USD, 2);
		
		// Act
		BasketItem baskeItem = new BasketItem(stockItem, exchangeRate, 1);
		Money convertedPrice = baskeItem.getPrice();
		
		// Assert
		Assert.assertEquals(PriceFactory.Instance.createPrice(10, Currency.GBP), convertedPrice);
	}
	
	@Test
	public void TestPriceIsCorrectGivenPriceInBaseCurrency() throws Exception{
		// Arrange
		Money price = PriceFactory.Instance.createPrice(10.0, Currency.GBP);
		StockItem stockItem = StockItemFactory.Instance.createStock("1", "Test Stock", price, false, true);
		ExchangeRate exchangeRate = ExchangeRateFactory.Instance.Create(Currency.GBP, Currency.GBP, 1);
		
		// Act
		BasketItem baskeItem = new BasketItem(stockItem, exchangeRate, 1);
		Money convertedPrice = baskeItem.getPrice();
		
		// Assert
		Assert.assertEquals(PriceFactory.Instance.createPrice(10, Currency.GBP), convertedPrice);
	}
}
