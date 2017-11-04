package com.spring.mybatis.user.web.entity;
import java.io.Serializable;
import java.util.Date;

/**
 * ClassName：AppTypeEntity<br>
 * Description：数据库中 app_type表对应的实体类        .<br>
 * @author auto
 * @Date 20170829202750
 * @since JRE 1.6.0_22  or higher
 */
public class AppTypeEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
	
		
		/**
		 * 
		 */
				private String apptype;
		
		/**
		 * 
		 */
				private String typename;
		
		/**
		 * 
		 */
				private String ordernum;
		
		/**
		 * 
		 */
				private short inmenu;
		
		/**
		 * 
		 */
						private long id;
		
	
			public String getApptype() {
			return apptype;
		}
		public void setApptype(String apptype) {
			this.apptype = apptype;
		}
			public String getTypename() {
			return typename;
		}
		public void setTypename(String typename) {
			this.typename = typename;
		}
			public String getOrdernum() {
			return ordernum;
		}
		public void setOrdernum(String ordernum) {
			this.ordernum = ordernum;
		}
			public short getInmenu() {
			return inmenu;
		}
		public void setInmenu(short inmenu) {
			this.inmenu = inmenu;
		}
			public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		
	
}