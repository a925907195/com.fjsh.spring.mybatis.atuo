package com.fjsh.spring.mybasti.auto.classcreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;
import com.fjsh.spring.mybasti.auto.velocity.VelocityUtils;

public class JarPomCreater {

	public static void createPom() {
		try {
			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("groupId", GlobalsParam.getPreference("groupId"));
			hm.put("artifactId", GlobalsParam.getPreference("artifactId"));
			String entityjava = VelocityUtils.mergeTemplate(hm,
					"jarpom.vm");
			File f = new File(GlobalsParam.getPreference("outputfolder") + "/pom.xml");
			FileOutputStream fos = new FileOutputStream(f);
			java.io.OutputStreamWriter osw = new OutputStreamWriter(fos,
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
