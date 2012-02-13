package com.longtask.tea.db;

import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.unitils.core.dbsupport.DbSupport;

import com.longtask.tea.db.map.TypeMap;
import com.longtask.tea.db.table.ColumnSchema;
import com.longtask.tea.domain.Column;
import com.longtask.tea.yaml.ParseYamlConfig;
/**
 * 
 * @author longhao
 * @since 
 * @version 
 *
 */
public class DbSchemaProvider {
	private DbSchemaProvider(){}
	
	private static DbSupport dbSupport = DbType.getInstance().getDbSupport();
	private static ColumnSchema columnSchema = DbType.getInstance().getColumnSchema();
	private static TypeMap typeMap = DbType.getInstance().getTypeMap();
	
	public static boolean isTablesExsit(Set<String> tablesName){
		Set<String> set = dbSupport.getTableNames();
		return CollectionUtils.isSubCollection(tablesName, set);
	}
	
	public static List<Column> getTableColumnNames(String tableName){
		String database = ParseYamlConfig.parseYaml().getSqlMap("database");
		List<Column> list = columnSchema.getTableColumns(database, tableName);
		for(Column column : list){
//			column.setJavaName(convertJavaName(column.getColumnName()));
//			String javaType = typeMap.javaTypeMap().get(column.getDateType().toUpperCase())
//								.getName().replace("java.lang.", "");
			String columnName = column.getColumnName();
			column.setJavaName(convertJavaName(columnName));
			String dataType = column.getDateType().toUpperCase();
			//get java type ,then drop java.lang.
			String javaType = typeMap.javaTypeMap().get(dataType).getName().replace("java.lang.", "");
			//if Primary key and 'int' in db , then will be 'long' in Java
			if(columnName.toLowerCase().endsWith("id") && javaType.equals("Integer")){
				javaType = "Long";
			}
			column.setJavaType(javaType);
			Object value = column.getDefaultValue();
			if(value == null){
				if("String".equals(javaType)){
					value = "";
				}
				if("Integer".equals(javaType)){
					value = 0;
				}
				if("Long".equals(javaType)){
					value = 0L;
				}
				if("java.util.Date".equals(javaType)){
					value = new java.util.Date();
				}
			}
		}
		return list;
	}
	
	public static String convertJavaName(String name){
		char underline = '_';
		String name2Lower = name.toLowerCase();
		int index = name2Lower.indexOf(underline);
		while(index != -1){
			name2Lower = name2Lower.substring(0, index) 
					+ Character.toUpperCase(name2Lower.charAt(index+1)) 
					+ name2Lower.substring(index+2);
			index = name2Lower.indexOf(underline);
		}
		
		return name2Lower;
	}
	
	public static String convertTableName(String tableName){
		String tableNameRtn = convertJavaName(tableName);
		return tableNameRtn.substring(0,1).toUpperCase() + tableNameRtn.substring(1);
	}

}
