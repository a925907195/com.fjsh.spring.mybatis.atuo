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
import java.util.List;
import java.util.Map;

public class SpringMVCPropertiesCreater {


    public static void createProperties(List<Table> tablelist) {
        try {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("package", GlobalsParam.getPreference("basepackage"));
            hm.put("tablelist", tablelist);
            hm.put("datetime", IConstants.CURRENT_TIME);
            //log4j.properties配置文件
            String entityjava = VelocityUtils.mergeTemplate(hm, "web/log4jproperties,vm");
            File f = new File(GlobalsParam.RESOURCE_FOLDER + IConstants.SYMBOL_SLASH + "log4j.properties");
            FileOutputStream fos = new FileOutputStream(f);
            java.io.OutputStreamWriter osw = new OutputStreamWriter(fos,
                    "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(entityjava);
            bw.flush();
            bw.close();
            fos.close();
            //生成spring-dao配置文件
            hm.put("mapperfolder", GlobalsParam.getPreference("Mappersfolder"));
            entityjava = VelocityUtils.mergeTemplate(hm, "spring-dao.vm");
            f = new File(GlobalsParam.RESOURCE_FOLDER + IConstants.SYMBOL_SLASH + "spring-dao.xml");
            fos = new FileOutputStream(f);
            osw = new OutputStreamWriter(fos,
                    "UTF-8");
            bw = new BufferedWriter(osw);
            bw.write(entityjava);
            bw.flush();
            bw.close();
            fos.close();
            //生成spring-mvc配置文件
            hm.put("mapperfolder", GlobalsParam.getPreference("Mappersfolder"));
            entityjava = VelocityUtils.mergeTemplate(hm, "spring-mvc.vm");
            f = new File(GlobalsParam.RESOURCE_FOLDER + IConstants.SYMBOL_SLASH + "spring-mvc.xml");
            fos = new FileOutputStream(f);
            osw = new OutputStreamWriter(fos,
                    "UTF-8");
            bw = new BufferedWriter(osw);
            bw.write(entityjava);
            bw.flush();
            bw.close();
            fos.close();
            //生成spring-service配置文件
            entityjava = VelocityUtils.mergeTemplate(hm, "spring-service.vm");
            f = new File(GlobalsParam.RESOURCE_FOLDER + IConstants.SYMBOL_SLASH + "spring-service.xml");
            fos = new FileOutputStream(f);
            osw = new OutputStreamWriter(fos,
                    "UTF-8");
            bw = new BufferedWriter(osw);
            bw.write(entityjava);
            bw.flush();
            bw.close();
            fos.close();
            //生成spring配置文件
            entityjava = VelocityUtils.mergeTemplate(hm, "web/springmvc-spring.vm");
            f = new File(GlobalsParam.RESOURCE_FOLDER + IConstants.SYMBOL_SLASH + "spring.xml");
            fos = new FileOutputStream(f);
            osw = new OutputStreamWriter(fos,
                    "UTF-8");
            bw = new BufferedWriter(osw);
            bw.write(entityjava);
            bw.flush();
            bw.close();
            fos.close();
            //生成数据库配置文件
            hm.put("connetionURL", GlobalsParam.getPreference("ConnetionURL"));
            hm.put("driversClass", GlobalsParam.getPreference("DriversClass"));
            hm.put("userName", GlobalsParam.getPreference("UserName"));
            hm.put("passWord", GlobalsParam.getPreference("PassWord"));
            entityjava = VelocityUtils.mergeTemplate(hm, "db.properties.vm");
            f = new File(GlobalsParam.DEV_PROPERTIES + IConstants.SYMBOL_SLASH + "db.properties");
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
