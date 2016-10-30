package eCom.unitTest.domain.order;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eCom.domain.cart.BasketItem;
import eCom.domain.order.BoughtItem;
import eCom.domain.order.Order;
import eCom.domain.order.ReceiptItem;
import eCom.factory.PriceFactory;
import eCom.factory.ReceiptLineFactory;
import eCom.finance.Currency;
import eCom.unitTest.fakes.FakeBasketItems;
import eCom.unitTest.fakes.FakeBoughtItems;

public class OrderTest {

	private List<BasketItem> basketItems;
	private List<BoughtItem> boughtItems;
	private Order order;
	private PriceFactory priceFactory = PriceFactory.Instance;
	private ReceiptLineFactory receiptLineFactory = ReceiptLineFactory.Instance;
	
	@Before
	public void setUp() throws Exception {
		basketItems = FakeBasketItems.getBasketItems();
		boughtItems = FakeBoughtItems.getBoughtItems();
		order = new Order(Currency.GBP, boughtItems, basketItems);
	}

	@Test
	public void testBananasReceiptItem() throws Exception{
		List<ReceiptItem> receiptItems = order.getRecieptItems();
		Assert.assertEquals(receiptItems.get(0), getBananasAnswer());
	}
	
	@Test
	public void testTotalReceiptItem() throws Exception{
		List<ReceiptItem> receiptItems = order.getRecieptItems();
		Assert.assertEquals(getTotal(), receiptItems.get(2));
	}
	
	@Test
	public void testOrangesReceiptItem() throws Exception{
		List<ReceiptItem> receiptItems = order.getRecieptItems();
		Assert.assertEquals(receiptItems.get(1), getOrangesAnswer());
	}
	
	@Test
	public void testAllReceiptItem() throws Exception{
		List<ReceiptItem> receiptItems = order.getRecieptItems();
		Assert.assertEquals(receiptItems.get(0), getBananasAnswer());
		Assert.assertEquals(receiptItems.get(1), getOrangesAnswer());
		Assert.assertEquals(receiptItems.get(2), getTotal());
	}
	
	private ReceiptItem getBananasAnswer() throws Exception{
		return receiptLineFactory.createRecieptItem("Bananas", priceFactory.createPrice(0.42, Currency.GBP), 2);
	}
	
	private ReceiptItem getOrangesAnswer() throws Exception{
		return receiptLineFactory.createRecieptItem("Oranges", priceFactory.createPrice(1.0, Currency.GBP), 3);
	}
	
	private ReceiptItem getTotal() throws Exception{
		return receiptLineFactory.createTotalItem(priceFactory.createPrice(3.84, Currency.GBP));
	}
}
