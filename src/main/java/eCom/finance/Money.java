package eCom.finance;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Money {

	private final BigDecimal amount;
	private final Currency currency;
	
	public Money(BigDecimal amount, Currency currency) {
		this(amount.doubleValue(), currency);
	}
	
	public Money(double amount, Currency currency) {
		this.amount = new BigDecimal(amount).setScale(2, RoundingMode.HALF_UP);
		this.currency = currency;
	}
	
	public BigDecimal getAmount(){
		return amount;
	}
	
	public Currency getCurrency(){
		return currency;
	}
	
	public Money Mulitply(double multiplier){
		return new Money(amount.multiply(BigDecimal.valueOf(multiplier)), currency);
	}
	
	public Money Add(Money that){
		return new Money(this.amount.add(that.amount), this.currency);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((currency == null) ? 0 : currency.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (currency == null) {
			if (other.currency != null)
				return false;
		} else if (!currency.equals(other.currency))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	
	
}
