package com.fjsh.spring.mybasti.auto.utils;

import java.util.Date;


/**
 * ClassName：Utils<br>
 * Description：通用工具类        .<br>
 * <p>company：58同城 <br>
 * Copyright：Copyright © 2011 58.com All Rights Reserved<br>
 *
 * @author auto
 * @Date 2011-7-30 21:47:50
 * @since JRE 1.6.0_22  or higher
 */
public interface IConstants {

    String BASE_DIR = System.getProperty("user.dir");
    String SYSTEM_GLOBALS_FILE = "SystemGlobals.properties";
    String SYMBOL_SLASH = "/";
    String LOG4J_PROPERTIES = BASE_DIR + SYMBOL_SLASH + "config/log4j.properties";
    String SYSTEM_GLOBAL_PROPERTIES = BASE_DIR + SYMBOL_SLASH + "config" + SYMBOL_SLASH + SYSTEM_GLOBALS_FILE;
    String CURRENT_TIME = DateTimeUtil.dateToStrOfDefaulfFormat(new Date());
    String VELOCITY_PROPERTIES = BASE_DIR + SYMBOL_SLASH + "config/velocity.properties";

    String SCF_CONFIG_NAME = "scf.config";
    String SCF_KEY_NAME = "scfkey.key";
    String ESB_NAME = "esb.properties";
    String ESB_KEY = "ershouchuangxin_ceping.key";


}