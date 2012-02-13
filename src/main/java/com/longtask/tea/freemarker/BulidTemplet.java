package com.longtask.tea.freemarker;


public interface BulidTemplet {

	final static String MAIN_PATH = "/src/main/java";
	final static String MAIN_CONF = "/src/main/resources";
	final static String TEST_PATH = "/src/test/java";
	final static String TEST_CONF = "/src/test/resources";

	boolean buildSourceFile(String tableName);

}