package com.fjsh.spring.mybasti.auto.creater;

import java.util.List;

import com.fjsh.spring.mybasti.auto.classcreator.BaseEntityDAOCreater;
import com.fjsh.spring.mybasti.auto.classcreator.BaseEntityServiceCreater;
import com.fjsh.spring.mybasti.auto.classcreator.ControllerDemoCreater;
import com.fjsh.spring.mybasti.auto.classcreator.EntityCreater;
import com.fjsh.spring.mybasti.auto.classcreator.SpringMVCCreateFolder;
import com.fjsh.spring.mybasti.auto.classcreator.SpringMVCPomCreater;
import com.fjsh.spring.mybasti.auto.classcreator.SpringMVCPropertiesCreater;
import com.fjsh.spring.mybasti.auto.db.DbUtils;
import com.fjsh.spring.mybasti.auto.db.Table;
import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;

/**
*@Title:springMVCCreator
*TODO:web工程生成
*@Description: 基于配置文件的方式生成代码，并带有部分模板，在idea编辑器下要去掉
*@author:a925907195@qq.com
*@date 2016年11月6日 下午2:57:47
*
*/
public class springMVCCreator {

	public static void main(String[] args) throws Throwable {
		//系统配置初始化
		GlobalsParam.init();
		// 生成必要的目录结构，同时拷贝必要的文件
		SpringMVCCreateFolder.createrFolder();
		List<Table> tablelist = DbUtils.getAllTableFromDb();
		for (Table td : tablelist) {
			// 生成实体类
			EntityCreater.createEntity(td);
			//生成dao接口和mapper基类实现
			BaseEntityDAOCreater.createBaseDao(td);
			// 生成Service 接口以及接口的实现
			BaseEntityServiceCreater.createBaseService(td);
		}	
		// 生成controller基础文件并将web基础配置文件拷贝到目的项目文件
		ControllerDemoCreater.createControllerFile();
		// 生成配置文件
		SpringMVCPropertiesCreater.createProperties(tablelist);
		// 生成pom文件
		SpringMVCPomCreater.createPom();

	}
}
