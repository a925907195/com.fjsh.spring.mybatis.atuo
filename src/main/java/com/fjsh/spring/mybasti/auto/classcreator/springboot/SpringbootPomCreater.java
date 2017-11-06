package com.fjsh.spring.mybasti.auto.classcreator.springboot;

import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;
import com.fjsh.spring.mybasti.auto.velocity.VelocityUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class SpringbootPomCreater {

	public static void createPom() {
		try {
			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("groupId", GlobalsParam.getPreference("groupId"));
			hm.put("artifactId", GlobalsParam.getPreference("artifactId"));
			String entityjava = VelocityUtils.mergeTemplate(hm,
					"springbootpom.vm");
			File f = new File(GlobalsParam.getPreference("outputfolder") + "/pom.xml");
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
