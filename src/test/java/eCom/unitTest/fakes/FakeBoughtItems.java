package eCom.unitTest.fakes;

import java.util.ArrayList;
import java.util.List;

import eCom.domain.order.BoughtItem;


public class FakeBoughtItems {

	public static List<BoughtItem> getBoughtItems(){
		BoughtItem bannana = new BoughtItem("1", 2);
		BoughtItem orange = new BoughtItem("2", 3);
		
		 List<BoughtItem> list = new ArrayList<>(2);
		 list.add(bannana);
		 list.add(orange);
		 return list;		
	}
}
