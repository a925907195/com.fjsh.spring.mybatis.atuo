package com.fjsh.spring.mybasti.auto.classcreator.springboot;

import com.fjsh.spring.mybasti.auto.db.Table;
import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;
import com.fjsh.spring.mybasti.auto.utils.IConstants;
import com.fjsh.spring.mybasti.auto.utils.StringUtils;
import com.fjsh.spring.mybasti.auto.velocity.VelocityUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class SpringBootTestCreater {

	public static void createBaseTest(Table table) {
		try {
			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("package", GlobalsParam.getPreference("basepackage"));
			hm.put("table", table);
			hm.put("datetime", IConstants.CURRENT_TIME);

			//test Service
			hm.put("columns", StringUtils.listToString(table.getColumns(), ','));
			String entityjava = VelocityUtils.mergeTemplate(hm, "test/testentitySpringboot.vm");
			File f = new File(GlobalsParam.TEST_SERVICE+IConstants.SYMBOL_SLASH+ table.getUpperCaseName()+ "MapperTest.java");
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
