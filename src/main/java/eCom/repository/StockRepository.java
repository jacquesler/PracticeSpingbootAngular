package eCom.repository;

import java.util.Set;

import eCom.domain.inventory.StockItem;

public interface StockRepository {

	public StockItem load(String id) throws Exception;
	public Set<StockItem> loadAll() throws Exception;
}
