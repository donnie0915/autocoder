package com.longtask.tea.freemarker.conf;

import java.util.Map;

import com.longtask.tea.db.DbSchemaProvider;
import com.longtask.tea.freemarker.AbstractBulidTemplet;
import com.longtask.tea.freemarker.BulidTemplet;
import com.longtask.tea.yaml.PackageConfigUtil;

public class SqlMapBulidTemplet extends AbstractBulidTemplet {

	@Override
	public boolean buildSourceFile(String tableName) {
		String configPath = "/ibatis";
		String outputDir = super.getBaseDir() + BulidTemplet.MAIN_CONF + configPath;
		String templateFileName = "sqlMap.ftl";
		String className = DbSchemaProvider.convertTableName(tableName);
		
		Map<String,Object> paramMap = super.getParamMap();
		paramMap.put("columns", DbSchemaProvider.getTableColumnNames(tableName));
		paramMap.put("package", PackageConfigUtil.getKey("domain",false));
		paramMap.put("className", className);
		paramMap.put("tableName", tableName);
		
		String domainPackage = PackageConfigUtil.getKey("domain",false);
		paramMap.put("domain", domainPackage + "." + className);
		
		String fileName = className  + "SqlMapping.xml";
		
		return super.buildJavaFile(templateFileName, paramMap, outputDir, fileName);
	}

}
