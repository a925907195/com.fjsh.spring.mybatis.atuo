package com.fjsh.spring.mybasti.auto.classcreator;

import com.fjsh.spring.mybasti.auto.db.Table;
import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;
import com.fjsh.spring.mybasti.auto.utils.IConstants;
import com.fjsh.spring.mybasti.auto.velocity.VelocityUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class SpringBootEntityCreater {
	public static void createEntity(Table table) {
		try {
			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("package", GlobalsParam.getPreference("basepackage"));
			hm.put("table", table);
			hm.put("datetime", IConstants.CURRENT_TIME);
			String entityjava = VelocityUtils.mergeTemplate(hm,
					"springbootentity.vm");
			File f = new File(GlobalsParam.ENTITY_FILEPATH + "/" + table.getUpperCaseName()+"Entity.java");
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos,
					"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(entityjava);
			bw.flush();
			bw.close();
			fos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
