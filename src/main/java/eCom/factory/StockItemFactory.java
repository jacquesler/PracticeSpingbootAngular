package eCom.factory;


import eCom.domain.inventory.StockItem;
import eCom.finance.Money;

public enum StockItemFactory implements DomainCsvFactory<StockItem> {
	Instance;	
	
	public StockItem createFromCsvLine(String[] nextLine) throws Exception{
	
		return createStock(nextLine[0], 
				nextLine[2],
				PriceFactory.Instance.createPrice(Double.parseDouble(nextLine[3]), nextLine[4]), 
				Boolean.parseBoolean(nextLine[5]),
				Boolean.parseBoolean(nextLine[6].trim()));
	}
	
	public StockItem createStock(String id, String name, Money price, boolean onSpecial, boolean hasStock){
		return new StockItem(id, name, price, onSpecial, hasStock);
	}
	
}
