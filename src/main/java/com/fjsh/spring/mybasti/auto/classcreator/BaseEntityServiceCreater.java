package com.fjsh.spring.mybasti.auto.classcreator;

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

public class BaseEntityServiceCreater {

    public static void createBaseService(Table table) {
        try {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("package", GlobalsParam.getPreference("basepackage"));
            hm.put("table", table);
            hm.put("datetime", IConstants.CURRENT_TIME);
            String entityjava = VelocityUtils.mergeTemplate(hm, "entityService.vm");
            File f = new File(GlobalsParam.ENTITY_SERVICEFILEPATH + IConstants.SYMBOL_SLASH + table.getUpperCaseName() + "Service.java");
            FileOutputStream fos = new FileOutputStream(f);
            java.io.OutputStreamWriter osw = new OutputStreamWriter(fos,
                    "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(entityjava);
            bw.flush();
            bw.close();
            fos.close();
            //ServiceImpl
            hm.put("columns", StringUtils.listToString(table.getColumns(), ','));
            entityjava = VelocityUtils.mergeTemplate(hm, "entityServiceImpl.vm");
            f = new File(GlobalsParam.ENTITY_SERVICE_IMPLFILEPATH + IConstants.SYMBOL_SLASH + table.getUpperCaseName() + "ServiceImpl.java");
            fos = new FileOutputStream(f);
            osw = new OutputStreamWriter(fos,
                    "UTF-8");
            bw = new BufferedWriter(osw);
            bw.write(entityjava);
            bw.flush();
            bw.close();
            fos.close();
            //test Service
            hm.put("columns", StringUtils.listToString(table.getColumns(), ','));
            entityjava = VelocityUtils.mergeTemplate(hm, "test/testentityService.vm");
            f = new File(GlobalsParam.TEST_SERVICE + IConstants.SYMBOL_SLASH + table.getUpperCaseName() + "ServiceTest.java");
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
