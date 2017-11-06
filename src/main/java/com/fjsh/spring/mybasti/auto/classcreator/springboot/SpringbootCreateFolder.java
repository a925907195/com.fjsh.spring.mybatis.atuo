package com.fjsh.spring.mybasti.auto.classcreator.springboot;

import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;

import java.io.File;

public class SpringbootCreateFolder {

	public static void createrFolder() throws Exception {
		//生成target目录
		String folder = GlobalsParam.getPreference("outputfolder")
		+ "/target";
		File f = new File(folder);
		if (!f.exists())
			f.mkdirs();
		
		//生成开发配置目录
		folder = GlobalsParam.getPreference("outputfolder")
		+ "/src/main/resources.dev";
		 f = new File(folder);
		if (!f.exists())
			f.mkdirs();
		
		 folder = GlobalsParam.getPreference("outputfolder")
			+ "/config";
			f = new File(folder);
			if (!f.exists())
				f.mkdirs();
		
		//FileUtils.copyFile(new File(GlobalsParam.getPreference("localproject")+"config/project/mysql.properties"), new File(folder+"/mysql.properties"));	
		//FileUtils.copyFile(new File(GlobalsParam.getPreference("localproject")+"config/project/swap.config"), new File(folder+"/swap.config"));	

		folder = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
						"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
						"/") + "/" + "config";
		f = new File(folder);
		if (!f.exists())
			f.mkdirs();

		
		folder = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
						"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
						"/") + "/" + "repository";
		f = new File(folder);
		if (!f.exists())
			f.mkdirs();
		//create dynamicsql folder
		folder = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
				"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
				"/") + "/" + "dynamicsql";
		f = new File(folder);
		if (!f.exists())
			f.mkdirs();
		//create main folder
		folder = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
				"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
				"/") + "/" + "main";
		f = new File(folder);
		if (!f.exists())
			f.mkdirs();


		folder = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
						"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
						"/") + "/" + "utils";
		f = new File(folder);
		if (!f.exists())
			f.mkdirs();

		// 生成resources目录
		folder = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("baseresourcesfolder").replaceAll(
						"\\.", "/") + "/";
		f = new File(folder);
		if (!f.exists())
			f.mkdirs();
		
//		// 生成spring配置文件夹
//		folder = GlobalsParam.getPreference("outputfolder")
//				+ "/"
//				+ GlobalsParam.getPreference("baseresourcesfolder").replaceAll(
//						"\\.", "/") + "/spring";
//		f = new File(folder);
//		if (!f.exists())
//			f.mkdirs();

		// 生成实体目录		
		 f = new File(GlobalsParam.ENTITY_FILEPATH);
		if (!f.exists())
			f.mkdirs();

		// -------------------生成test

		folder = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basetestjavafolder").replaceAll(
						"\\.", "/") + "/";
		f = new File(folder);
		if (!f.exists())
			f.mkdirs();
		//create test service folder
				folder = GlobalsParam.getPreference("outputfolder")
						+ "/"
						+ GlobalsParam.getPreference("basetestjavafolder").replaceAll(
								"\\.", "/")
						+ "/"
						+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
								"/") + "/" + "service";
				f = new File(folder);
				if (!f.exists())
					f.mkdirs();
				

		folder = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basetestresourcesfolder")
						.replaceAll("\\.", "/") + "/";
		f = new File(folder);
		if (!f.exists())
			f.mkdirs();
		folder = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basetestresourcesfolder")
						.replaceAll("\\.", "/") + "/META-INF";
		f = new File(folder);
		if (!f.exists())
			f.mkdirs();
	}
	
	
}
