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

import com.hqb360.analysis.report.domain.entity.OriginCategory;

public class OriginCategoryDaoTest extends AbstractSpringDaoTest<OriginCategory> {

	@Autowired
	private OriginCategoryDao<OriginCategory> originCategoryDao;

	private Map<String , OriginCategory> data ;
	@BeforeMethod
	public void setBefore() {
		String pg = this.getClass().getPackage().getName().replace(".", "/");
		data = super.getYamlData( pg + "/OriginCategoryDaoTest.yaml");
	}
	
	 @Test
	public void testInsertOriginCategory() {
		OriginCategory originCategory = data.get("insert");
		originCategoryDao.insert(originCategory);	
		originCategory = originCategoryDao.find(originCategory , null);
		Assert.assertNotNull(originCategory);	
	}
	
    @Test
	public void testUpdateOriginCategory() {
		OriginCategory originCategory = data.get("update");
		originCategoryDao.update(originCategory);
	}
	
	 @Test
	public void testFindOriginCategory() {
		OriginCategory originCategory = data.get("find");
		originCategory = originCategoryDao.find(originCategory , null);
		Assert.assertNotNull(originCategory);
	}
	
    @Test
	public void testListOriginCategory() {
		OriginCategory originCategory = data.get("list");
		ListAdapter<OriginCategory> adapter = new DefaultListAdapter<OriginCategory>();
		//adapter.setOrderItem("id");
		adapter.setOrderType("desc");
		List<OriginCategory>  originCategorys = originCategoryDao.list(originCategory , adapter);
		for(OriginCategory originCategorytmp :  originCategorys) {
			Assert.assertNotNull(originCategorytmp);
		}
		Assert.assertTrue(originCategorys.size() > 0);
		
		Integer count = originCategoryDao.listCount(originCategory , adapter);
		Assert.assertTrue(count > 0);
	}
	
	
    @Test
	public void testDeleteOriginCategory() {
		OriginCategory originCategory = data.get("find");
		originCategory = originCategoryDao.find(originCategory , null);
		OriginCategory delOriginCategory = new OriginCategory();
		//TODO set id
		originCategoryDao.delete(delOriginCategory);
		originCategory = originCategoryDao.find(originCategory , null);
		Assert.assertNull(originCategory);
	}

}

