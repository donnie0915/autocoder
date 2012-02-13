package com.hqb360.analysis.report.biz.dao.impl ;

import org.springframework.stereotype.Repository;

import com.hqb360.analysis.report.biz.dao.GeneralDao;

import com.hqb360.common.dao.BaseDaoImpl;
import com.hqb360.common.dao.DaoStatementName;
import com.hqb360.common.dao.DefaultDaoStatementName;
/**
 * 
 * @author longhao
 * @version 1.0.0
 *
 */
@Repository("generalDao")
public class GeneralDaoImpl<General> extends BaseDaoImpl<General> implements  GeneralDao<General>{
	@Override
	public DaoStatementName getDaoStatementName() {
		return  new DefaultDaoStatementName(){
			public String getDomainName(){
				return "General";
			}
		};
	}
} 
