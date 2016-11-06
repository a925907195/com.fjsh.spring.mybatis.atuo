package com.fjsh.spring.mybasti.auto.classcreator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import com.fjsh.spring.mybasti.auto.utils.FileUtil;
import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;
import com.fjsh.spring.mybasti.auto.utils.IConstants;
import com.fjsh.spring.mybasti.auto.velocity.VelocityUtils;

public class ControllerDemoCreater {


	public static void createControllerFile() {
		try {
			//create index
			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("package", GlobalsParam.getPreference("basepackage"));		
			hm.put("datetime", IConstants.CURRENT_TIME);			
			String entityjava = VelocityUtils.mergeTemplate(hm, "web/IndexController.vm");			
			File f = new File(GlobalsParam.DEV_CONTROLLER +IConstants.SYMBOL_SLASH+ "IndexController.java");
			FileOutputStream fos = new FileOutputStream(f);
			java.io.OutputStreamWriter osw = new OutputStreamWriter(fos,
					"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(entityjava);
			bw.flush();
			bw.close();
			fos.close();	
			//create DemoController	
			 entityjava = VelocityUtils.mergeTemplate(hm, "web/DemoController.vm");			
			 f = new File(GlobalsParam.DEV_CONTROLLER +IConstants.SYMBOL_SLASH+ "DemoController.java");
			 fos = new FileOutputStream(f);
			 osw = new OutputStreamWriter(fos,
					"UTF-8");
			 bw = new BufferedWriter(osw);
			bw.write(entityjava);
			bw.flush();
			bw.close();
			fos.close();
			//递归拷贝webapp文件到目的文件
          FileUtil.copyFolder(new File(IConstants.BASE_DIR+"/config/template/web/webapp"),new File( GlobalsParam.getPreference("outputfolder")+ "/src/main/webapp"));  

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
