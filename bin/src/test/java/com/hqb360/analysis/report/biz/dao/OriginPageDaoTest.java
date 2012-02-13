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

import com.hqb360.analysis.report.domain.entity.OriginPage;

public class OriginPageDaoTest extends AbstractSpringDaoTest<OriginPage> {

	@Autowired
	private OriginPageDao<OriginPage> originPageDao;

	private Map<String , OriginPage> data ;
	@BeforeMethod
	public void setBefore() {
		String pg = this.getClass().getPackage().getName().replace(".", "/");
		data = super.getYamlData( pg + "/OriginPageDaoTest.yaml");
	}
	
	 @Test
	public void testInsertOriginPage() {
		OriginPage originPage = data.get("insert");
		originPageDao.insert(originPage);	
		originPage = originPageDao.find(originPage , null);
		Assert.assertNotNull(originPage);	
	}
	
    @Test
	public void testUpdateOriginPage() {
		OriginPage originPage = data.get("update");
		originPageDao.update(originPage);
	}
	
	 @Test
	public void testFindOriginPage() {
		OriginPage originPage = data.get("find");
		originPage = originPageDao.find(originPage , null);
		Assert.assertNotNull(originPage);
	}
	
    @Test
	public void testListOriginPage() {
		OriginPage originPage = data.get("list");
		ListAdapter<OriginPage> adapter = new DefaultListAdapter<OriginPage>();
		//adapter.setOrderItem("id");
		adapter.setOrderType("desc");
		List<OriginPage>  originPages = originPageDao.list(originPage , adapter);
		for(OriginPage originPagetmp :  originPages) {
			Assert.assertNotNull(originPagetmp);
		}
		Assert.assertTrue(originPages.size() > 0);
		
		Integer count = originPageDao.listCount(originPage , adapter);
		Assert.assertTrue(count > 0);
	}
	
	
    @Test
	public void testDeleteOriginPage() {
		OriginPage originPage = data.get("find");
		originPage = originPageDao.find(originPage , null);
		OriginPage delOriginPage = new OriginPage();
		//TODO set id
		originPageDao.delete(delOriginPage);
		originPage = originPageDao.find(originPage , null);
		Assert.assertNull(originPage);
	}

}

