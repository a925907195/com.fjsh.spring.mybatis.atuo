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

public class BaseEntityDAOCreater {

    public static void createBaseDao(Table table) {
        try {
            Map<String, Object> hm = new HashMap<String, Object>();
            hm.put("package", GlobalsParam.getPreference("basepackage"));
            hm.put("table", table);
            hm.put("datetime", IConstants.CURRENT_TIME);
            String entityjava = VelocityUtils.mergeTemplate(hm, "entityDao.vm");
            File f = new File(GlobalsParam.ENTITY_DAOFILEPATH + IConstants.SYMBOL_SLASH + table.getUpperCaseName() + "Dao.java");
            FileOutputStream fos = new FileOutputStream(f);
            java.io.OutputStreamWriter osw = new OutputStreamWriter(fos,
                    "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);
            bw.write(entityjava);
            bw.flush();
            bw.close();
            fos.close();
            //Mappers映射信息
            hm.put("columns", StringUtils.listToDBColumn(table.getColumns(), ','));
            entityjava = VelocityUtils.mergeTemplate(hm, "mapper.vm");
            f = new File(GlobalsParam.RESOURCE_FOLDER + IConstants.SYMBOL_SLASH + GlobalsParam.getPreference("Mappersfolder") + IConstants.SYMBOL_SLASH + table.getUpperCaseName() + "Mapper.xml");
            fos = new FileOutputStream(f);
            osw = new OutputStreamWriter(fos,
                    "UTF-8");
            bw = new BufferedWriter(osw);
            bw.write(entityjava);
            bw.flush();
            bw.close();
            fos.close();
//            //动态sql语句信息
//            hm.put("columns", StringUtils.listToString(table.getColumns(), ','));
//            entityjava = VelocityUtils.mergeTemplate(hm, "springbootDynaSql.vm");
//            f = new File(GlobalsParam.ENTITY_DYSQLFILEPATH + IConstants.SYMBOL_SLASH + table.getUpperCaseName() + "Sql.java");
//            fos = new FileOutputStream(f);
//            osw = new OutputStreamWriter(fos,
//                    "UTF-8");
//            bw = new BufferedWriter(osw);
//            bw.write(entityjava);
//            bw.flush();
//            bw.close();
//            fos.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
