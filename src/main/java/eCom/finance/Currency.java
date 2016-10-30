package eCom.finance;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Currency {
	
	GBP('£', "GBP", "United Kingdom"),
	USD('$', "USD", "United States"),
	ZAR('R', "ZAR", "South Africa");
	
	private final char symbol;
	private final String currency;
	private final String country;
	 
		
	private Currency(char symbol, String currency, String country) {		
		this.symbol = symbol;
		this.currency = currency;
		this.country = country;
	}
	
	public char getSymbol() {
		return symbol;
	}
	
	public String getCurrenyCode() {
		return currency;
	}
	public String getCountry() {
		return country;
	}
	
	public static Currency getCurrency(String code) throws Exception{
		List<Currency> currencies = Arrays.asList(GBP, USD, ZAR);
		Optional<Currency> currency = currencies.stream()
	    .filter( c -> c.currency.equalsIgnoreCase(code)).findFirst();
		return currency.orElseThrow(() -> new Exception("Code does not exist"));
	}
}
