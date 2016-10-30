package eCom.unitTest.finance;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import eCom.finance.Currency;
import eCom.finance.Money;

public class MoneyTest {

	@Test
	public void TestMoneyMulitpliesCorrectly(){
		// Arrange
		Money money = new Money(BigDecimal.valueOf(10.0), Currency.GBP);
		double multiplier = 2;
		
		// Act
		Money result = money.Mulitply(multiplier);
		
		// Assert
		Money expected= new Money(BigDecimal.valueOf(20.00d), Currency.GBP);
		Assert.assertEquals(expected, result);
		
	}
	
	@Test
	public void TestMoneyEqualCreatedFromDoubleOrDigDecimal(){
		// Arrange
		Money doubleInput = new Money(11.245, Currency.GBP);
		Money BigDecimalInput = new Money(BigDecimal.valueOf(11.245), Currency.GBP);
		
		// Assert
		Assert.assertEquals(doubleInput,BigDecimalInput);
		
	}
}
