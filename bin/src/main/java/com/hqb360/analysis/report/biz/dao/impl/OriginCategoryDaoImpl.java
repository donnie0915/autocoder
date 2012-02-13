package com.hqb360.analysis.report.biz.dao.impl ;

import org.springframework.stereotype.Repository;

import com.hqb360.analysis.report.biz.dao.OriginCategoryDao;

import com.hqb360.common.dao.BaseDaoImpl;
import com.hqb360.common.dao.DaoStatementName;
import com.hqb360.common.dao.DefaultDaoStatementName;
/**
 * 
 * @author longhao
 * @version 1.0.0
 *
 */
@Repository("originCategoryDao")
public class OriginCategoryDaoImpl<OriginCategory> extends BaseDaoImpl<OriginCategory> implements  OriginCategoryDao<OriginCategory>{
	@Override
	public DaoStatementName getDaoStatementName() {
		return  new DefaultDaoStatementName(){
			public String getDomainName(){
				return "OriginCategory";
			}
		};
	}
} 
