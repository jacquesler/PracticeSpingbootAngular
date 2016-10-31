package eCom.repository;

import java.util.Set;

import eCom.finance.Currency;
import eCom.finance.ExchangeRate;

public interface ExchangeRateRepository {

	public ExchangeRate load(String code) throws Exception;
	public ExchangeRate load(Currency currency) throws Exception;
	public Set<ExchangeRate> loadAll() throws Exception;
}
 