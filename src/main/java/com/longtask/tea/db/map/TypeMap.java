package com.longtask.tea.db.map;

import java.util.Map;

public interface TypeMap {
	Map<String, Class<?>> javaTypeMap();
	
	Map<String, Integer> sqlTypeMap();
}
