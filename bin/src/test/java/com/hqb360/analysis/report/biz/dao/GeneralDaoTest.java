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

import com.hqb360.analysis.report.domain.entity.General;

public class GeneralDaoTest extends AbstractSpringDaoTest<General> {

	@Autowired
	private GeneralDao<General> generalDao;

	private Map<String , General> data ;
	@BeforeMethod
	public void setBefore() {
		String pg = this.getClass().getPackage().getName().replace(".", "/");
		data = super.getYamlData( pg + "/GeneralDaoTest.yaml");
	}
	
	 @Test
	public void testInsertGeneral() {
		General general = data.get("insert");
		generalDao.insert(general);	
		general = generalDao.find(general , null);
		Assert.assertNotNull(general);	
	}
	
    @Test
	public void testUpdateGeneral() {
		General general = data.get("update");
		generalDao.update(general);
	}
	
	 @Test
	public void testFindGeneral() {
		General general = data.get("find");
		general = generalDao.find(general , null);
		Assert.assertNotNull(general);
	}
	
    @Test
	public void testListGeneral() {
		General general = data.get("list");
		ListAdapter<General> adapter = new DefaultListAdapter<General>();
		//adapter.setOrderItem("id");
		adapter.setOrderType("desc");
		List<General>  generals = generalDao.list(general , adapter);
		for(General generaltmp :  generals) {
			Assert.assertNotNull(generaltmp);
		}
		Assert.assertTrue(generals.size() > 0);
		
		Integer count = generalDao.listCount(general , adapter);
		Assert.assertTrue(count > 0);
	}
	
	
    @Test
	public void testDeleteGeneral() {
		General general = data.get("find");
		general = generalDao.find(general , null);
		General delGeneral = new General();
		//TODO set id
		generalDao.delete(delGeneral);
		general = generalDao.find(general , null);
		Assert.assertNull(general);
	}

}

