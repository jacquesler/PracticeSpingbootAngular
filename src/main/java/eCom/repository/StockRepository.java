package eCom.repository;

import java.util.List;

import eCom.domain.inventory.StockItem;

public interface StockRepository {

	public StockItem load(String id) throws Exception;
	public List<StockItem> loadAll() throws Exception;
}
