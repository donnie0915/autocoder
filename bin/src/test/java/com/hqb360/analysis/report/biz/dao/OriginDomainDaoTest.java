package com.hqb360.analysis.report.biz.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hqb360.test.base.AbstractSpringDaoTest;
import com.hqb360.common.dao.adapter.DefaultListAdapter;
import com.hqb360.common.dao.adapter.ListAdapter;

import com.hqb360.analysis.report.domain.entity.OriginDomain;

public class OriginDomainDaoTest extends AbstractSpringDaoTest<OriginDomain> {

	@Autowired
	private OriginDomainDao<OriginDomain> originDomainDao;

	private Map<String , OriginDomain> data ;
	@BeforeMethod
	public void setBefore() {
		String pg = this.getClass().getPackage().getName().replace(".", "/");
		data = super.getYamlData( pg + "/OriginDomainDaoTest.yaml");
	}
	
	 @Test
	public void testInsertOriginDomain() {
		OriginDomain originDomain = data.get("insert");
		originDomainDao.insert(originDomain);	
		originDomain = originDomainDao.find(originDomain , null);
		Assert.assertNotNull(originDomain);	
	}
	
    @Test
	public void testUpdateOriginDomain() {
		OriginDomain originDomain = data.get("update");
		originDomainDao.update(originDomain);
	}
	
	 @Test
	public void testFindOriginDomain() {
		OriginDomain originDomain = data.get("find");
		originDomain = originDomainDao.find(originDomain , null);
		Assert.assertNotNull(originDomain);
	}
	
    @Test
	public void testListOriginDomain() {
		OriginDomain originDomain = data.get("list");
		ListAdapter<OriginDomain> adapter = new DefaultListAdapter<OriginDomain>();
		//adapter.setOrderItem("id");
		adapter.setOrderType("desc");
		List<OriginDomain>  originDomains = originDomainDao.list(originDomain , adapter);
		for(OriginDomain originDomaintmp :  originDomains) {
			Assert.assertNotNull(originDomaintmp);
		}
		Assert.assertTrue(originDomains.size() > 0);
		
		Integer count = originDomainDao.listCount(originDomain , adapter);
		Assert.assertTrue(count > 0);
	}
	
	
    @Test
	public void testDeleteOriginDomain() {
		OriginDomain originDomain = data.get("find");
		originDomain = originDomainDao.find(originDomain , null);
		OriginDomain delOriginDomain = new OriginDomain();
		//TODO set id
		originDomainDao.delete(delOriginDomain);
		originDomain = originDomainDao.find(originDomain , null);
		Assert.assertNull(originDomain);
	}

}

