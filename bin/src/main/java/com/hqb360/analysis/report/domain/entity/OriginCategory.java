package com.hqb360.analysis.report.domain.entity ;
/**
 * 
 * @author longhao
 * @version 1.0.0
 *
 */
import java.io.Serializable;

public class OriginCategory implements Serializable {
	
	private static final long serialVersionUID = -9052338515052942429L;

		// 唯一索引
		private Long id ; 
		
		// 是否天或小时
		private Integer isDate ; 
		
		// 搜索访问次数
		private Integer clickSearch ; 
		
		// 其他访问次数
		private Integer clickOther ; 
		
		// 直接输入或书签
		private Integer directInput ; 
		
		// 录入时间
		private Integer createTime ; 
		
		// 新增时间
		private java.util.Date addTiem ; 
		
	
		public Long  getId(){
			return id ;
		} 
		public void setId(Long id){
			this.id = id ;
		}

		public Integer  getIsDate(){
			return isDate ;
		} 
		public void setIsDate(Integer isDate){
			this.isDate = isDate ;
		}

		public Integer  getClickSearch(){
			return clickSearch ;
		} 
		public void setClickSearch(Integer clickSearch){
			this.clickSearch = clickSearch ;
		}

		public Integer  getClickOther(){
			return clickOther ;
		} 
		public void setClickOther(Integer clickOther){
			this.clickOther = clickOther ;
		}

		public Integer  getDirectInput(){
			return directInput ;
		} 
		public void setDirectInput(Integer directInput){
			this.directInput = directInput ;
		}

		public Integer  getCreateTime(){
			return createTime ;
		} 
		public void setCreateTime(Integer createTime){
			this.createTime = createTime ;
		}

		public java.util.Date  getAddTiem(){
			return addTiem ;
		} 
		public void setAddTiem(java.util.Date addTiem){
			this.addTiem = addTiem ;
		}


} 
