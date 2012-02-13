package com.longtask.tea.freemarker.main;

import java.util.Map;

import com.longtask.tea.db.DbSchemaProvider;
import com.longtask.tea.freemarker.AbstractBulidTemplet;
import com.longtask.tea.freemarker.BulidTemplet;
import com.longtask.tea.yaml.PackageConfigUtil;
import com.longtask.tea.yaml.ParseYamlConfig;

public class DaoImplFileBulidTemplet extends AbstractBulidTemplet {

	@Override
	public boolean buildSourceFile(String tableName) {
		String configPath = PackageConfigUtil.getKey("daoImpl",true);
		String outputDir = super.getBaseDir() + BulidTemplet.MAIN_PATH + configPath;
		String templateFileName = "daoImpl.ftl";
		String className = DbSchemaProvider.convertTableName(tableName);
		
		Map<String,Object> paramMap = super.getParamMap();
		paramMap.put("package", PackageConfigUtil.getKey("daoImpl",false));
		paramMap.put("className", className);
		
		String domainPackage = PackageConfigUtil.getKey("domain",false);
		paramMap.put("domain", domainPackage + "." + className);
		String daoPackage = PackageConfigUtil.getKey("dao",false);
		paramMap.put("dao",daoPackage+ "." + className + "Dao");
		
		paramMap.put("base_dao_impl", ParseYamlConfig.parseYaml().getUserMap("base_dao_impl"));
		paramMap.put("dao_statement_name", ParseYamlConfig.parseYaml().getUserMap("dao_statement_name"));
		paramMap.put("default_dao_statement_name", ParseYamlConfig.parseYaml().getUserMap("default_dao_statement_name"));
		
		String fileName = className  + "DaoImpl.java";
		
		return super.buildJavaFile(templateFileName, paramMap, outputDir, fileName);
	}

}
