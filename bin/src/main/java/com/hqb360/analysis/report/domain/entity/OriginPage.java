package com.hqb360.analysis.report.domain.entity ;
/**
 * 
 * @author longhao
 * @version 1.0.0
 *
 */
import java.io.Serializable;

public class OriginPage implements Serializable {
	
	private static final long serialVersionUID = -4852894514870987928L;

		// 唯一标识
		private Long id ; 
		
		// PV
		private Integer pv ; 
		
		// UV
		private Integer uv ; 
		
		// IP
		private Integer ip ; 
		
		// NEW_PV
		private Integer newPv ; 
		
		// NEW_UV
		private Integer newUv ; 
		
		// 域名
		private String refererUrl ; 
		
		// 域名类型0无来路 1其它 2搜索
		private Integer urlType ; 
		
		// 0小时1天
		private Integer isDate ; 
		
		// 访问时间
		private Integer createTime ; 
		
		// 总浏览数
		private Integer countPv ; 
		
		// 新增时间
		private java.util.Date addTime ; 
		
	
		public Long  getId(){
			return id ;
		} 
		public void setId(Long id){
			this.id = id ;
		}

		public Integer  getPv(){
			return pv ;
		} 
		public void setPv(Integer pv){
			this.pv = pv ;
		}

		public Integer  getUv(){
			return uv ;
		} 
		public void setUv(Integer uv){
			this.uv = uv ;
		}

		public Integer  getIp(){
			return ip ;
		} 
		public void setIp(Integer ip){
			this.ip = ip ;
		}

		public Integer  getNewPv(){
			return newPv ;
		} 
		public void setNewPv(Integer newPv){
			this.newPv = newPv ;
		}

		public Integer  getNewUv(){
			return newUv ;
		} 
		public void setNewUv(Integer newUv){
			this.newUv = newUv ;
		}

		public String  getRefererUrl(){
			return refererUrl ;
		} 
		public void setRefererUrl(String refererUrl){
			this.refererUrl = refererUrl ;
		}

		public Integer  getUrlType(){
			return urlType ;
		} 
		public void setUrlType(Integer urlType){
			this.urlType = urlType ;
		}

		public Integer  getIsDate(){
			return isDate ;
		} 
		public void setIsDate(Integer isDate){
			this.isDate = isDate ;
		}

		public Integer  getCreateTime(){
			return createTime ;
		} 
		public void setCreateTime(Integer createTime){
			this.createTime = createTime ;
		}

		public Integer  getCountPv(){
			return countPv ;
		} 
		public void setCountPv(Integer countPv){
			this.countPv = countPv ;
		}

		public java.util.Date  getAddTime(){
			return addTime ;
		} 
		public void setAddTime(java.util.Date addTime){
			this.addTime = addTime ;
		}


} 
