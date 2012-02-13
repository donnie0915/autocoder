package com.longtask.tea.execute;

import java.io.File;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.longtask.tea.freemarker.AbstractBulidTemplet;
import com.longtask.tea.freemarker.BulidTemplet;
import com.longtask.tea.yaml.ParseYamlConfig;

public final class Executor {
	private final static Logger logger = LoggerFactory.getLogger(AbstractBulidTemplet.class);
	private static final String ABS_PATH = Executor.class.getResource("/").getPath();
	private static final String TEA_PATH = "com/longtask/tea/";
	
	/**
	 * @param args
	 */
	public static void main(String[] args){
		logger.info("Create starting !");
		List<Class<?>> list = new ArrayList<Class<?>>();
		try{
			list = Executor.getTempletClass(list,ABS_PATH + TEA_PATH);
			Executor.exec(list);
		}catch(Exception e){
			logger.error("Executor error:",e);
		}
		logger.info("Create end!");
	}
	
	/**
	 * 遍历生成相关的模板文件
	 * @param list
	 * @throws Exception
	 */
	protected static void exec(List<Class<?>> list){
		String[] tables = ParseYamlConfig.parseYaml().getSqlMap("tables").split(",");
		for(String table:tables){
			for(Class<?> clazz : list){
				BulidTemplet bulidTemplet = null;
				try {
					bulidTemplet = (BulidTemplet)clazz.newInstance();
				} catch (InstantiationException e) {
					logger.error("InstantiationException :",e);
					return;
				} catch (IllegalAccessException e) {
					logger.error("IllegalAccessException :",e);
					return;
				}
				bulidTemplet.buildSourceFile(table);
			}
		}
	}

	
	/**
	 * 找到BulidTemplet接口的所有非抽象实现类
	 * @param list
	 * @param path
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws Exception
	 */
	protected static List<Class<?>> getTempletClass(List<Class<?>> list,String path) 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		if(path.contains(".svn")){
			return list;
		}
		File[] files = new File(path).listFiles();
		
		if(files != null){
			for(File file:files){
				if(file.isDirectory()){
					getTempletClass(list,path + file.getName() + "/");
				}else{
					String className = path.replace(ABS_PATH, "").replace("/", ".") + file.getName();
					className = className.substring(0, className.length()-6);
					Class<?> clazz = Thread.currentThread().getContextClassLoader().loadClass(className);
					if (!Modifier.isAbstract(clazz.getModifiers())
							&& Modifier.isPublic(clazz.getModifiers())
							&& (clazz.newInstance() instanceof BulidTemplet)) {
						list.add(clazz);
					}
				}
			}
		}
		return list;
	}
	
}