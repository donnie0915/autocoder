package com.longtask.tea.freemarker.main;

import java.util.Map;

import com.longtask.tea.db.DbSchemaProvider;
import com.longtask.tea.freemarker.AbstractBulidTemplet;
import com.longtask.tea.freemarker.BulidTemplet;
import com.longtask.tea.yaml.PackageConfigUtil;
import com.longtask.tea.yaml.ParseYamlConfig;

public class DaoFileBulidTemplet extends AbstractBulidTemplet {

	@Override
	public boolean buildSourceFile(String tableName) {
		String configPath = PackageConfigUtil.getKey("dao",true);
		String outputDir = super.getBaseDir() + BulidTemplet.MAIN_PATH + configPath;
		String templateFileName = "dao.ftl";
		String className = DbSchemaProvider.convertTableName(tableName);
		
		Map<String,Object> paramMap = super.getParamMap();
		paramMap.put("columns", DbSchemaProvider.getTableColumnNames(tableName));
		paramMap.put("package", PackageConfigUtil.getKey("dao",false));
		paramMap.put("className", className);
		
		String domainPackage = PackageConfigUtil.getKey("domain",false);
		paramMap.put("domain", domainPackage + "." + className);
		paramMap.put("base_dao", ParseYamlConfig.parseYaml().getUserMap("base_dao"));
		
		String fileName = className  + "Dao.java";
		
		return super.buildJavaFile(templateFileName, paramMap, outputDir, fileName);
	}

}
