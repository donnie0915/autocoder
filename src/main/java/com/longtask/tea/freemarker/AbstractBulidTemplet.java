package com.longtask.tea.freemarker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.longtask.tea.freemarker.model.LowerFirstCharacter;
import com.longtask.tea.freemarker.model.UpperFirstCharacter;
import com.longtask.tea.yaml.ParseYamlConfig;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
/**
 * 根据模板文件生成代码的基类
 * @author	longhao
 * @since	2011-11-23 下午02:42:57
 * @version	1.0.0
 */
public abstract class AbstractBulidTemplet implements BulidTemplet {
	
	protected final static transient Logger logger = LoggerFactory.getLogger(AbstractBulidTemplet.class);
		
	protected static final Configuration freemarkerCfg;
	/**
	 * 设置freemarker参数
	 * @param dir
	 * @throws IOException
	 */
	static{
		freemarkerCfg = new Configuration();
		String usrDir = getBaseDir();
		try {
			freemarkerCfg.setDirectoryForTemplateLoading(new File(usrDir + File.pathSeparator + "template"));
		} catch (IOException e) {
			logger.error("freemarkerCfg.setDirectoryForTemplateLoading error",e);
		}
		freemarkerCfg.setObjectWrapper(new DefaultObjectWrapper());
		freemarkerCfg.setDefaultEncoding("UTF-8");
		freemarkerCfg.setSharedVariable("upperFirstChar", new UpperFirstCharacter());//设置公用变量
		freemarkerCfg.setSharedVariable("lowerFirstChar", new LowerFirstCharacter());//设置公用变量
    }
	
	protected boolean buildJavaFile(String templateFileName, Map<?, ?> paramMap,String outputDir, String fileName){
		try {
			Template template = freemarkerCfg.getTemplate(templateFileName);
			template.setEncoding("UTF-8");
			// 创建生成文件目录
			File file = new File(outputDir);
			if(!file.exists()){
				file.mkdirs();
			}
			if(!outputDir.endsWith(File.pathSeparator)){
				outputDir = outputDir + File.pathSeparator;
			}
			File javaFile = new File(outputDir + fileName);
			logger.info("---------------------------Create file is "+javaFile);
			Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(javaFile), "UTF-8"));
			template.process(paramMap, out);
			out.flush();
			return true;
		} catch (TemplateException ex) {
			logger.error("Build Error : " + templateFileName, ex);
			return false;
		} catch (IOException e) {
			logger.error("Build Error : " + templateFileName, e);
			return false;
		}
	}
	
	protected Map<String,Object> getParamMap(){
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("author", ParseYamlConfig.parseYaml().getName());
		paramMap.put("version", ParseYamlConfig.parseYaml().getVersion());
		return paramMap;
	}
	
	
	protected static String getBaseDir(){
		String usrDir = System.getProperty("user.dir");
		if(usrDir.endsWith(File.pathSeparator + "lib")){
			usrDir = usrDir.substring(0, usrDir.length()-5);
		}
		return usrDir;
	}
}
