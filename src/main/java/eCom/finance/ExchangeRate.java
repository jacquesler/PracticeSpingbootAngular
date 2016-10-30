package eCom.finance;

public class ExchangeRate {

	private final Currency baseCurrency;
	private final Currency counterCurrency;
	private final double rate;

	public ExchangeRate(Currency baseCurrency, Currency counterCurrency, double rate) {
		super();
		this.baseCurrency = baseCurrency;
		this.counterCurrency = counterCurrency;
		this.rate = rate;
	}

	public Money calculateBaseCurrencyPrice(Money price) {
		if (price.getCurrency().equals(baseCurrency))
			return price;
		else if (price.getCurrency().equals(counterCurrency))
			return new Money(price.Mulitply(1/rate).getAmount(), baseCurrency);
		else
			throw new RuntimeException("Currency is not in slected pair");
	}

	@Override
	public String toString() {
		return "ExchangeRate [baseCurrency=" + baseCurrency + ", counterCurrency=" + counterCurrency + ", rate=" + rate
				+ "]";
	}

	public Currency getBaseCurrency() {
		return baseCurrency;
	}

	public Currency getCounterCurrency() {
		return counterCurrency;
	}

	public double getRate() {
		return rate;
	}
	 
	public static ExchangeRate DefaultExchangeRate(Currency currency){
		return new ExchangeRate(currency, currency, 1);
	}
}
