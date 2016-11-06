package com.fjsh.spring.mybasti.auto.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;

public class DbUtils {
	private static Log log = LogFactory.getLog(DbUtils.class);

	public static List<Table> getAllTableFromDb() {
		List<Table> tablelist = new ArrayList<Table>(1000);
		try {
			Class.forName(GlobalsParam.getPreference("DriversClass"));
			Connection conn = DriverManager.getConnection(
					GlobalsParam.getPreference("ConnetionURL"),
					GlobalsParam.getPreference("UserName"),
					GlobalsParam.getPreference("PassWord"));
			PreparedStatement pstmt = null;
			ResultSetMetaData rsmd = null;
			ResultSet rs = null;
			ResultSet pkrs = null;
			Map<String, String> pkmap = null;
			Map<String, String> descmap = null;
			if (conn == null) {
				log.info("无法获取数据库连接");
				return null;
			}
			DatabaseMetaData databaseMetaData = conn.getMetaData();
			
			ResultSet tablers = databaseMetaData.getTables(null, "%", "%",
					new String[] { "TABLE" });
			while (tablers.next()) {
				pkmap = new HashMap<String, String>();
				descmap=new HashMap<String, String>();
				Table tb = new Table();

				String tableName = tablers.getString("TABLE_NAME");
				// System.out.println(Table.getFormatTablename(tableName));
				tb.setTablename(convertName(Table.getFormatTablename(tableName)));
				tb.setDbtablename(tableName);

				pkrs = databaseMetaData.getPrimaryKeys(null, null, tableName);
				while (pkrs.next()) {
					pkmap.put(pkrs.getString(4), null);
					// System.err.println("COLUMN_NAME: " + pkrs.getObject(4));
				}
				
				
				ResultSet columnSet = databaseMetaData.getColumns(null, "%",
						tableName, "%");
				while(columnSet.next()){
					String columnName = columnSet.getString("COLUMN_NAME");
					  //备注
					String columnComment = columnSet.getString("REMARKS");
					descmap.put(columnName, columnComment);
				}
				
				pstmt = conn.prepareStatement("SELECT * FROM " + tableName +" limit 0,2");
				rs = pstmt.executeQuery();
				rsmd = rs.getMetaData();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					Column cn = new Column();					
					cn.setDbType(mysqlType2MybatisJDBCType(rsmd.getColumnTypeName(i)));
					cn.setJavaname(convertName(rsmd.getColumnName(i).toLowerCase()));
					cn.setDbname(rsmd.getColumnName(i));
					cn.setJavaType(mysqlType2JavaType(cn.getDbType()));
					cn.setDesc(descmap.get(cn.getDbname()));
					if (pkmap.containsKey(cn.getDbname())) {
						cn.setPk("1");
						tb.setPkJavaType(cn.getJavaType());
					}
					tb.getColumns().add(cn);
				}
				tablelist.add(tb);
				pstmt = null;
				rsmd = null;
				rs = null;
				pkrs = null;
				pkmap = null;
				columnSet=null;
				descmap=null;
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tablelist;
	}

	private static String convertName(String column){
		String[] cls=column.split("_");
		StringBuffer sb=new StringBuffer(cls[0]);
		
		int l=cls.length;
		for(int i=1;i<l ;i++){
			sb.append(firstLetterUpcase(cls[i]));
		}
		return sb.toString();
	}
	public static String firstLetterUpcase(String str){
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}
			
	private static String mysqlType2MybatisJDBCType(String mysqltype) {
		if (StringUtils.isBlank(mysqltype))
			return "";
		if ("VARCHAR".equalsIgnoreCase(mysqltype))
			return "VARCHAR";
		else if ("CHAR".equalsIgnoreCase(mysqltype))
			return "VARCHAR";
		else if ("BLOB".equalsIgnoreCase(mysqltype))
			return "BLOB";
		else if ("TEXT".equalsIgnoreCase(mysqltype))
			return "BLOB";
		else if ("INT".equalsIgnoreCase(mysqltype)  || "INT UNSIGNED".equalsIgnoreCase(mysqltype))
			return "INTEGER";
		else if ("INTEGER".equalsIgnoreCase(mysqltype))
			return "INTEGER";
		else if ("TINYINT".equalsIgnoreCase(mysqltype)  || "TINYINT UNSIGNED".equalsIgnoreCase(mysqltype))
			return "TINYINT";
		else if ("SMALLINT".equalsIgnoreCase(mysqltype))
			return "SMALLINT";
		else if ("MEDIUMINT".equalsIgnoreCase(mysqltype))
			return "INTEGER";
		else if ("BIT".equalsIgnoreCase(mysqltype))
			return "BIT";
		else if ("BIGINT".equalsIgnoreCase(mysqltype) || "BIGINT UNSIGNED".equalsIgnoreCase(mysqltype))
			return "BIGINT";
		else if ("FLOAT".equalsIgnoreCase(mysqltype))
			return "FLOAT";
		else if ("DOUBLE".equalsIgnoreCase(mysqltype))
			return "DOUBLE";
		else if ("DECIMAL".equalsIgnoreCase(mysqltype))
			return "DOUBLE";
		else if ("BOOLEAN".equalsIgnoreCase(mysqltype))
			return "BOOLEAN";
		else if ("ID".equalsIgnoreCase(mysqltype))
			return "BIGINT";
		else if ("DATE".equalsIgnoreCase(mysqltype))
			return "DATE";
		else if ("TIME".equalsIgnoreCase(mysqltype))
			return "DATE";
		else if ("DATETIME".equalsIgnoreCase(mysqltype))
			return "TIMESTAMP";
		else if ("TIMESTAMP".equalsIgnoreCase(mysqltype))
			return "TIMESTAMP";
		else if ("YEAR".equalsIgnoreCase(mysqltype))
			return "DATE";
		else
			return "";

	}
	private static String mysqlType2JavaType(String mysqltype) {
		if (StringUtils.isBlank(mysqltype))
			return "";
		if ("VARCHAR".equalsIgnoreCase(mysqltype))
			return String.class.getSimpleName();
		else if ("CHAR".equalsIgnoreCase(mysqltype))
			return String.class.getSimpleName();
		else if ("BLOB".equalsIgnoreCase(mysqltype))
			return byte[].class.getSimpleName();
		else if ("TEXT".equalsIgnoreCase(mysqltype))
			return String.class.getSimpleName();
		else if ("INT".equalsIgnoreCase(mysqltype)  || "INT UNSIGNED".equalsIgnoreCase(mysqltype))
			return int.class.getSimpleName();
		else if ("INTEGER".equalsIgnoreCase(mysqltype))
			return int.class.getSimpleName();
		else if ("TINYINT".equalsIgnoreCase(mysqltype)  || "TINYINT UNSIGNED".equalsIgnoreCase(mysqltype))
			return short.class.getSimpleName();
		else if ("SMALLINT".equalsIgnoreCase(mysqltype))
			return int.class.getSimpleName();
		else if ("MEDIUMINT".equalsIgnoreCase(mysqltype))
			return int.class.getSimpleName();
		else if ("BIT".equalsIgnoreCase(mysqltype))
			return boolean.class.getSimpleName();
		else if ("BIGINT".equalsIgnoreCase(mysqltype) || "BIGINT UNSIGNED".equalsIgnoreCase(mysqltype))
			return long.class.getSimpleName();
		else if ("FLOAT".equalsIgnoreCase(mysqltype))
			return float.class.getSimpleName();
		else if ("DOUBLE".equalsIgnoreCase(mysqltype))
			return double.class.getSimpleName();
		else if ("DECIMAL".equalsIgnoreCase(mysqltype))
			return double.class.getSimpleName();
		else if ("BOOLEAN".equalsIgnoreCase(mysqltype))
			return short.class.getSimpleName();
		else if ("ID".equalsIgnoreCase(mysqltype))
			return long.class.getSimpleName();
		else if ("DATE".equalsIgnoreCase(mysqltype))
			return Date.class.getSimpleName();
		else if ("TIME".equalsIgnoreCase(mysqltype))
			return Date.class.getSimpleName();
		else if ("DATETIME".equalsIgnoreCase(mysqltype))
			return Date.class.getSimpleName();
		else if ("TIMESTAMP".equalsIgnoreCase(mysqltype))
			return Date.class.getSimpleName();
		else if ("YEAR".equalsIgnoreCase(mysqltype))
			return Date.class.getSimpleName();
		else
			return "";

	}

	public static void main(String[] args) {
		
		System.out.println(int.class.getSimpleName());
	}
}
