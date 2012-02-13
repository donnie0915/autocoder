package com.longtask.tea.freemarker.test;

import java.util.Map;

import com.longtask.tea.db.DbSchemaProvider;
import com.longtask.tea.freemarker.AbstractBulidTemplet;
import com.longtask.tea.freemarker.BulidTemplet;
import com.longtask.tea.yaml.PackageConfigUtil;
import com.longtask.tea.yaml.ParseYamlConfig;

public class DaoImplTestBulidTemplet extends AbstractBulidTemplet {

	@Override
	public boolean buildSourceFile(String tableName) {
		String configPath = PackageConfigUtil.getKey("dao",true);
		String outputDir = super.getBaseDir() + BulidTemplet.TEST_PATH + configPath;
		String templateFileName = "daoTester.ftl";
		String className = DbSchemaProvider.convertTableName(tableName);
		
		Map<String,Object> paramMap = super.getParamMap();
		paramMap.put("columns", DbSchemaProvider.getTableColumnNames(tableName));
		paramMap.put("package", PackageConfigUtil.getKey("dao",false));
		paramMap.put("className", className);
		String domainPackage = PackageConfigUtil.getKey("domain",false);
		paramMap.put("domain", domainPackage + "." + className);
		
		paramMap.put("baseTester", PackageConfigUtil.getKey("dao",false)+ ".AbstractSpringDaoTest");
		paramMap.put("default_list_adapter", ParseYamlConfig.parseYaml().getUserMap("default_list_adapter"));
		paramMap.put("list_adapter", ParseYamlConfig.parseYaml().getUserMap("list_adapter"));
		paramMap.put("abstract_spring_dao_test", ParseYamlConfig.parseYaml().getUserMap("abstract_spring_dao_test"));
		
		String fileName = className  + "DaoTest.java";
		
		
		return super.buildJavaFile(templateFileName, paramMap, outputDir, fileName);
	}

}
