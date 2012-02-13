package com.longtask.tea.freemarker.conf;

import java.util.Map;

import com.longtask.tea.db.DbSchemaProvider;
import com.longtask.tea.freemarker.AbstractBulidTemplet;
import com.longtask.tea.freemarker.BulidTemplet;
import com.longtask.tea.yaml.ParseYamlConfig;

public class DaoConfBulidTemplet extends AbstractBulidTemplet {

	@Override
	public boolean buildSourceFile(String tableName) {
		String outputDir = super.getBaseDir() + BulidTemplet.MAIN_CONF;
		String templateFileName = "daoConf.ftl";
		String className = DbSchemaProvider.convertTableName(tableName);
		
		Map<String,Object> paramMap = super.getParamMap();
		//paramMap.put("columns", DbSchemaProvider.getTableColumnNames(tableName));
		//paramMap.put("package", PackageConfigUtil.getKey("dao",false));
		paramMap.put("daoConf", className  + "SqlMapping.xml");
		
		String fileName = ParseYamlConfig.parseYaml().getUserMap("ibatis_config_name");
		
		return super.buildJavaFile(templateFileName, paramMap, outputDir, fileName);
	}

}
