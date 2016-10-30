package eCom.unitTest.domain.order;

import org.junit.Assert;
import org.junit.Test;

import eCom.domain.order.ReceiptItem;
import eCom.factory.PriceFactory;
import eCom.finance.Currency;

public class ReceiptItemTest {

	@Test
	public void TestCorrectPriceGivenPerQuantity() throws Exception{
		// Arrange
		ReceiptItem receiptItem = new ReceiptItem("Apple", PriceFactory.Instance.createPrice(2.0, Currency.GBP), 3);
		
		// Act
		double result = receiptItem.getTotal();
		
		// Assert
		Assert.assertEquals(6.0, result,0.0);
	}
	
	@Test
	public void TestCorrectPriceGivenPerQuantityWithUSDCurrency() throws Exception{
		// Arrange
		ReceiptItem receiptItem = new ReceiptItem("Apple", PriceFactory.Instance.createPrice(2.0, Currency.USD), 3);
		
		// Act
		double result = receiptItem.getTotal();
		
		// Assert
		Assert.assertEquals(6.0, result,0.0);
	}
}
