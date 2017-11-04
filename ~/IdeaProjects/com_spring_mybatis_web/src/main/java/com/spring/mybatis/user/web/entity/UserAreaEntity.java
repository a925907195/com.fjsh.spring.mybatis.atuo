package com.spring.mybatis.user.web.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * ClassName：UserAreaEntity<br>
 * Description：数据库中 t_user_area表对应的实体类        .<br>
 * @author auto
 * @Date 20170829202750
 * @since JRE 1.6.0_22  or higher
 */
public class UserAreaEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
	
		
		/**
		 * 
		 */
						private long id;
		
		/**
		 * 
		 */
				private String name;
		
		/**
		 * 
		 */
				private String sex;
		
		/**
		 * 
		 */
				private String age;
		
		/**
		 * 
		 */
				private String phone;
		
		/**
		 * 
		 */
				private long areacompid;
		
		/**
		 * 
		 */
				private short status;
		
		/**
		 * 
		 */
				private String remark;
		
		/**
		 * 
		 */
				private Date addtime;
		
		/**
		 * 
		 */
				private Date updatetime;
		
	
			public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
			public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
			public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
			public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
			public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
			public long getAreacompid() {
			return areacompid;
		}
		public void setAreacompid(long areacompid) {
			this.areacompid = areacompid;
		}
			public short getStatus() {
			return status;
		}
		public void setStatus(short status) {
			this.status = status;
		}
			public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
			public Date getAddtime() {
			return addtime;
		}
		public void setAddtime(Date addtime) {
			this.addtime = addtime;
		}
			public Date getUpdatetime() {
			return updatetime;
		}
		public void setUpdatetime(Date updatetime) {
			this.updatetime = updatetime;
		}
		
	
}