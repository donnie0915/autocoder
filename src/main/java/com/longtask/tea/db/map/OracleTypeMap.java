package com.longtask.tea.db.map;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;
/**
 *  oracle 的数据类型和java数据类型的对比
 * @author	longhao
 * @since	2011-11-23 下午02:13:57
 * @version	1.0.0
 */
public class OracleTypeMap implements TypeMap{
	public Map<String, Class<?>> javaTypeMap(){
		return java;
	}
	public Map<String, Integer> sqlTypeMap(){
		return sql;
	}
	protected static Map<String, Class<?>> java = new HashMap<String, Class<?>>(); 
	static {
		java.put("VARCHAR", String.class);
		java.put("VARCHAR2", String.class);
		java.put("NVARCHAR2", String.class);
		java.put("CHAR", String.class);
		java.put("NCHAR", String.class);
		java.put("CLOB", String.class);
		java.put("ROWID", String.class);
		java.put("BINARY_INTEGER", BigDecimal.class);
		java.put("NUMBER", BigDecimal.class);
		java.put("FLOAT", BigDecimal.class);
		java.put("DATE", Timestamp.class);
		java.put("TIMESTAMP", Timestamp.class);
		java.put("REF", ResultSet.class);
	}

	protected static Map<String, Integer> sql = new HashMap<String, Integer>();
	static {
		sql.put("VARCHAR", Types.VARCHAR);
		sql.put("VARCHAR2", Types.VARCHAR);
		sql.put("NVARCHAR2", Types.VARCHAR);
		sql.put("CHAR", Types.VARCHAR);
		sql.put("NCHAR", Types.VARCHAR);
		sql.put("CLOB", Types.VARCHAR);
		sql.put("ROWID", Types.VARCHAR);
		sql.put("BINARY_INTEGER", Types.NUMERIC);
		sql.put("NUMBER", Types.NUMERIC);
		sql.put("FLOAT", Types.NUMERIC);
		sql.put("DATE", Types.TIMESTAMP);
		sql.put("TIMESTAMP", Types.TIMESTAMP);
		// sql.put("REF", OracleTypes.CURSOR);
	}
}
