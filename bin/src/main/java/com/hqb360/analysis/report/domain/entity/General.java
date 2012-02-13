package com.hqb360.analysis.report.domain.entity ;
/**
 * 
 * @author longhao
 * @version 1.0.0
 *
 */
import java.io.Serializable;

public class General implements Serializable {
	
	private static final long serialVersionUID = -5542202769781419681L;

		// 唯一标识
		private Long id ; 
		
		// pv
		private Integer pv ; 
		
		// uv
		private Integer uv ; 
		
		// ip地址
		private String ip ; 
		
		// 独立访客
		private Integer onlyVisitor ; 
		
		// 停留时间
		private Integer liveTime ; 
		
		// 是否天计算
		private Integer isDate ; 
		
		// 分析开始时间
		private Integer startTime ; 
		
		// 分析结束时间
		private Integer endTiem ; 
		
		// 分析器运行时间
		private Integer addTime ; 
		
		// 访问一次的数
		private Integer onlyClick ; 
		
	
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

		public String  getIp(){
			return ip ;
		} 
		public void setIp(String ip){
			this.ip = ip ;
		}

		public Integer  getOnlyVisitor(){
			return onlyVisitor ;
		} 
		public void setOnlyVisitor(Integer onlyVisitor){
			this.onlyVisitor = onlyVisitor ;
		}

		public Integer  getLiveTime(){
			return liveTime ;
		} 
		public void setLiveTime(Integer liveTime){
			this.liveTime = liveTime ;
		}

		public Integer  getIsDate(){
			return isDate ;
		} 
		public void setIsDate(Integer isDate){
			this.isDate = isDate ;
		}

		public Integer  getStartTime(){
			return startTime ;
		} 
		public void setStartTime(Integer startTime){
			this.startTime = startTime ;
		}

		public Integer  getEndTiem(){
			return endTiem ;
		} 
		public void setEndTiem(Integer endTiem){
			this.endTiem = endTiem ;
		}

		public Integer  getAddTime(){
			return addTime ;
		} 
		public void setAddTime(Integer addTime){
			this.addTime = addTime ;
		}

		public Integer  getOnlyClick(){
			return onlyClick ;
		} 
		public void setOnlyClick(Integer onlyClick){
			this.onlyClick = onlyClick ;
		}


} 
