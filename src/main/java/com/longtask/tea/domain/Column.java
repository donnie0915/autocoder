package com.longtask.tea.domain;

public class Column {
	private String columnName;
	private String dateType;
	private String columnCommit;
	
	private String javaType;
	private String javaName;
	private String commit;
	
	private Object defaultValue;
		


	@Override
	public String toString() {
		return "Column [columnName=" + columnName + ", dateType=" + dateType
				+ ", columnCommit=" + columnCommit + ", javaType=" + javaType
				+ ", javaName=" + javaName + ", commit=" + commit + "]";
	}
	
	public Object getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(Object defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	public String getJavaName() {
		return javaName;
	}
	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}
	public String getCommit() {
		return commit;
	}
	public void setCommit(String commit) {
		this.commit = commit;
	}
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public String getColumnCommit() {
		return columnCommit;
	}
	public void setColumnCommit(String columnCommit) {
		this.columnCommit = columnCommit;
	}
}	
