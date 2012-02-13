package com.hqb360.analysis.report.biz.dao.impl ;

import org.springframework.stereotype.Repository;

import com.hqb360.analysis.report.biz.dao.OriginPageDao;

import com.hqb360.common.dao.BaseDaoImpl;
import com.hqb360.common.dao.DaoStatementName;
import com.hqb360.common.dao.DefaultDaoStatementName;
/**
 * 
 * @author longhao
 * @version 1.0.0
 *
 */
@Repository("originPageDao")
public class OriginPageDaoImpl<OriginPage> extends BaseDaoImpl<OriginPage> implements  OriginPageDao<OriginPage>{
	@Override
	public DaoStatementName getDaoStatementName() {
		return  new DefaultDaoStatementName(){
			public String getDomainName(){
				return "OriginPage";
			}
		};
	}
} 
