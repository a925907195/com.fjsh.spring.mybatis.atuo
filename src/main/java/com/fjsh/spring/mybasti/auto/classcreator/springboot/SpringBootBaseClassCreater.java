package com.fjsh.spring.mybasti.auto.classcreator.springboot;

import com.fjsh.spring.mybasti.auto.db.Table;
import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;
import com.fjsh.spring.mybasti.auto.utils.IConstants;
import com.fjsh.spring.mybasti.auto.velocity.VelocityUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpringBootBaseClassCreater {


	public static void createClasses(List<Table> tablelist) {
		try {
			//StartApp 主入口
			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("package", GlobalsParam.getPreference("basepackage"));
			hm.put("tablelist", tablelist);
			hm.put("datetime", IConstants.CURRENT_TIME);
			//app主入口 StartApp
			String entityjava = VelocityUtils.mergeTemplate(hm, "startApp.vm");
			File f = new File(GlobalsParam.ENTITY_MAINFILEPATH +IConstants.SYMBOL_SLASH+ "StartApp.java");
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos,
					"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(entityjava);
			bw.flush();
			bw.close();
			fos.close();
			//生成JpaConfig数据库链接配置类
			entityjava = VelocityUtils.mergeTemplate(hm, "jpaConfig.vm");
			f = new File(GlobalsParam.BASEFILEPATH +IConstants.SYMBOL_SLASH+ "JpaConfig.java");
			fos = new FileOutputStream(f);
			osw = new OutputStreamWriter(fos,
					"UTF-8");
			bw = new BufferedWriter(osw);
			bw.write(entityjava);
			bw.flush();
			bw.close();
			fos.close();

			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
