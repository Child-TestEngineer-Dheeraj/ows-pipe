package utils;

import java.util.HashMap;
import java.util.Map;

public class SearchContext {
	
	private static ThreadLocal<Map<String, String>> contextdata= ThreadLocal.withInitial(HashMap::new);

	public static String getContextdata(String Key) {
		return contextdata.get().get(Key);
	}

	public static void setContextdata(String Key, String Value) {
		contextdata.get().put(Key, Value);
	}
	
	  public static void remove() {
		  contextdata.remove();  
	    }
	
	
	
	

}
