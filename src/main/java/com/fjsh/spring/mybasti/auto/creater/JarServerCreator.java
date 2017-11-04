package com.fjsh.spring.mybasti.auto.creater;

import java.util.List;

import com.fjsh.spring.mybasti.auto.classcreator.BaseEntityDAOCreater;
import com.fjsh.spring.mybasti.auto.classcreator.BaseEntityServiceCreater;
import com.fjsh.spring.mybasti.auto.classcreator.CreateFolder;
import com.fjsh.spring.mybasti.auto.classcreator.EntityCreater;
import com.fjsh.spring.mybasti.auto.classcreator.JarPomCreater;
import com.fjsh.spring.mybasti.auto.classcreator.PropertiesCreater;
import com.fjsh.spring.mybasti.auto.db.DbUtils;
import com.fjsh.spring.mybasti.auto.db.Table;
import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;

/**
*@Title:JarServerCreator
*TODO:jar工程生成
*@Description: 基于配置文件生成jar程序
*@author:a925907195@qq.com
*@date 2016年11月6日 下午2:58:01
*
*/
public class JarServerCreator {

	public static void main(String[] args) throws Throwable {
		//系统配置初始化
		GlobalsParam.init();
		// 生成必要的目录结构，同时拷贝必要的文件
		CreateFolder.createrFolder();
		List<Table> tablelist = DbUtils.getAllTableFromDb();
		for (Table td : tablelist) {
			// 生成实体类
			EntityCreater.createEntity(td);
			//生成dao接口和mapper基类实现
			BaseEntityDAOCreater.createBaseDao(td);
			// 生成Service 接口以及接口的实现,并实现基本的测试接口
			BaseEntityServiceCreater.createBaseService(td);
		}	
		// 生成配置文件
		PropertiesCreater.createProperties(tablelist);
		// 生成pom文件
		JarPomCreater.createPom();

	}
}
