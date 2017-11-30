package com.fjsh.spring.mybasti.auto.creater;

import com.fjsh.spring.mybasti.auto.classcreator.springboot.*;
import com.fjsh.spring.mybasti.auto.db.DbUtils;
import com.fjsh.spring.mybasti.auto.db.Table;
import com.fjsh.spring.mybasti.auto.utils.GlobalsParam;

import java.util.List;

/**
 * @Title:SpringBootCreator TODO:
 * @Description: 基于纯注解生成springboot程序，包括mybatis也基于注解实现
 * @author:a925907195@qq.com
 * @date 2017年09月25日 下午2:58:01
 */
public class SpringBootCreator {

    public static void main(String[] args) throws Throwable {
        //系统配置初始化
        GlobalsParam.init();
        // 生成必要的目录结构，同时拷贝必要的文件
        SpringbootCreateFolder.createrFolder();
        List<Table> tablelist = DbUtils.getAllTableFromDb();
        for (Table td : tablelist) {
            // 生成实体类
            SpringBootEntityCreater.createEntity(td);
            //生成dao接口和mapper基类实现
            SpringBootDAOCreater.createBaseDao(td);
            // 生成基本的测试接口
            SpringBootTestCreater.createBaseTest(td);
        }
        //生成基础app运行程序以及jpaconfig配置文件
        SpringBootBaseClassCreater.createClasses(tablelist);
        // 生成配置文件
        SpringBootPropertiesCreater.createProperties(tablelist);
        // 生成pom文件
        SpringbootPomCreater.createPom();

    }
}
