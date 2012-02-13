package com.longtask.tea.db.map;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * mysql的数据类型和java数据类型的对比
 * @author	longhao
 * @since	2011-11-23 下午02:13:33
 * @version	1.0.0
 */
public class MySQLTypeMap implements TypeMap{
	
	public Map<String, Class<?>> javaTypeMap(){
		return java;
	}
	public Map<String, Integer> sqlTypeMap(){
		return sql;
	}
	
	private static Map<String, Class<?>> java = new HashMap<String, Class<?>>(); 
	static {
		java.put("VARCHAR", String.class);
		java.put("CHAR", String.class);
		java.put("TEXT", String.class);
		java.put("MEDIUMTEXT", String.class);
		java.put("TINYINT", Integer.class);
		java.put("SMALLINT", Integer.class);
		java.put("MEDIUMINT", Integer.class);
		java.put("INT", Integer.class);
		java.put("INTEGER", Integer.class);
		java.put("BIGINT", Long.class);
		java.put("INTEGER UNSIGNED", Long.class);
		java.put("INT UNSIGNED", Long.class);
		java.put("FLOAT", Float.class);
		java.put("DOUBLE", Double.class);
		java.put("DECIMAL", BigDecimal.class);
		java.put("DEC", BigDecimal.class);
		java.put("DATE", Date.class);
		java.put("TIMESTAMP", Date.class);
		java.put("DATETIME", Date.class);
		java.put("ENUM", String.class);
		// java.put("DATE", java.sql.Date.class);
		// java.put("TIMESTAMP", java.sql.Timestamp.class);
		// java.put("DATETIME", java.sql.Timestamp.class);
		java.put("BIT", Boolean.class);
	}
	
	private static Map<String, Integer> sql = new HashMap<String, Integer>();
	static {
		sql.put("VARCHAR", Types.VARCHAR);
		sql.put("CHAR", Types.VARCHAR);
		sql.put("TEXT", Types.VARCHAR);
		sql.put("MEDIUMTEXT", Types.VARCHAR);
		sql.put("TINYINT", Types.INTEGER);
		sql.put("SMALLINT", Types.INTEGER);
		sql.put("MEDIUMINT", Types.INTEGER);
		sql.put("INT", Types.INTEGER);
		sql.put("INTEGER", Types.INTEGER);
		sql.put("BIGINT", Types.BIGINT);
		sql.put("INTEGER UNSIGNED", Types.BIGINT);
		sql.put("INT UNSIGNED", Types.BIGINT);
		sql.put("FLOAT", Types.FLOAT);
		sql.put("DOUBLE", Types.DOUBLE);
		sql.put("DECIMAL", Types.NUMERIC);
		sql.put("DEC", Types.NUMERIC);
		sql.put("DATE", Types.DATE);
		sql.put("ENUM", Types.OTHER);
		sql.put("TIMESTAMP", Types.TIMESTAMP);
		sql.put("DATETIME", Types.TIMESTAMP);
		sql.put("BIT", Types.BOOLEAN);
	}
	
}
