package com.fjsh.spring.mybasti.auto.db;

public class Column {

	private String javaname;

	private String dbname;

	private String javaType;

	private String dbType;
	
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getJavaType() {
		return javaType;
	}

	public String getJavaname() {
		return javaname;
	}

	public void setJavaname(String javaname) {
		this.javaname = javaname;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	private String pk = "0";


	
	
	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public String getUpperCol(String col){
		return col.substring(0,1).toUpperCase()+col.substring(1);
	}

}
