package eCom.repository;

import java.util.Set;

import eCom.domain.inventory.StockItem;
import eCom.factory.StockItemFactory;
import eCom.utility.CollectorUtility;

public class CsvStockRepository implements StockRepository {

	@Override
	public StockItem load(String id) throws Exception {
		return loadAll().stream().filter((i) -> i.getId().equalsIgnoreCase(id))
				.collect(CollectorUtility.singleItemCollector());
	}

	@Override
	public Set<StockItem> loadAll() throws Exception {
		CsvCommandReader<StockItem> csvCommandReader = new CsvCommandReader<StockItem>("Stock.csv", StockItemFactory.Instance);
		return csvCommandReader.loadAll().getDomainList();
	}

}
