package eCom.utility;

import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CollectorUtility {

	public static <T> Collector<T, ?, T> singleItemCollector() {
	    return Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> {
	                if (list.size() != 1) {
	                    throw new IllegalStateException();
	                }
	                return list.get(0);
	            }
	    );
	}
	
	
}
