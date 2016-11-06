package com.fjsh.spring.mybasti.auto.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.PropertyConfigurator;

/**
*@Title:GlobalsParam
*TODO:
*@Description: 初始化系统变量
*@author:a925907195@qq.com
*@date 2016年10月30日 下午1:19:53
*
*/
public class GlobalsParam {	
	/** 域 preferences. */
	private static Properties preferences = new Properties();
	public static String ENTITY_FILEPATH;
	public static String ENTITY_DAOFILEPATH ;
	public static String ENTITY_SERVICEFILEPATH ;
	public static String ENTITY_SERVICE_IMPLFILEPATH ;
	public static String DEV_PROPERTIES ;
	public static String TEST_SERVICE ;
	public static String DEV_CONTROLLER ;
	public static String RESOURCE_FOLDER;
	public static void init()
	{		
		PropertyConfigurator.configure(IConstants.LOG4J_PROPERTIES);
        GlobalsParam.loadConfig(new File(IConstants.SYSTEM_GLOBAL_PROPERTIES));
        ENTITY_FILEPATH = GlobalsParam.getPreference("outputfolder")	+ "/"
    			+ GlobalsParam.getPreference("basejavafolder").replaceAll("\\.", "/")	+ "/"
    			+ GlobalsParam.getPreference("basepackage").replaceAll("\\.","/") + "/" + "entity";
        ENTITY_DAOFILEPATH = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
						"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
						"/") + "/" + "dao";	
        ENTITY_SERVICEFILEPATH = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
						"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
						"/") + "/" + "service";	
        ENTITY_SERVICE_IMPLFILEPATH = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
						"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
						"/") + "/" + "service/impl";	
        DEV_PROPERTIES=GlobalsParam.getPreference("outputfolder")
		+ "/src/main/resources.dev";
        RESOURCE_FOLDER=GlobalsParam.getPreference("outputfolder")
		+ "/"+ GlobalsParam.getPreference("baseresourcesfolder").replaceAll("\\.", "/") + "/";
        TEST_SERVICE = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basetestjavafolder").replaceAll(
						"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
						"/") + "/" + "service";
        DEV_CONTROLLER = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
						"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
						"/") + "/" + "controller";
	}
	
	/**
	 * 获取域 Preference.
	 * 
	 * @param key
	 *            the key
	 * @return Preference
	 */
	public static String getPreference(String key) {
		String s = preferences.getProperty(key);
		if (s != null)
			s = s.trim();
		return s;
	}

	public static String getPreference(String key, String defaultValue) {
		String s = preferences.getProperty(key);
		if (s == null)
			return defaultValue;
		else
			return s;
	}

	/**
	 * 获取域 Preference.
	 * 
	 * @param key
	 *            the key
	 * @param params
	 *            the params
	 * @return Preference
	 */
	public static String getPreference(String key, Object... params) {
		String message = preferences.getProperty(key);
		if (message != null)
			message = message.trim();

		if (params == null || params.length == 0)
			return message;

		String[] ss = new String[params.length];
		Object o = null;
		for (int i = 0; i < params.length; i++) {
			o = params[i];
			if (o == null) {
				ss[i] = "";
			} else {
				ss[i] = o.toString();
			}
		}

		return replacePlaceHolder(message, ss);
	}

	/**
	 * Sets the preference.
	 * 
	 * @param key
	 *            the key
	 * @param value
	 *            the value
	 */
	public static void setPreference(String key, String value) {
		if (value != null) {
			value = value.trim();
			preferences.setProperty(key, value);
		} else {
			preferences.remove(key);
		}
	}

	public static int getIntPreference(String key, int defaultValue) {
		String s = getPreference(key);
		if (StringUtils.isBlank(s))
			return defaultValue;
		else
			return Integer.parseInt(s);
	}

	public static void setIntPreference(String key, int value) {
		setPreference(key, String.valueOf(value));
	}

	public static long getLongPreference(String key, long defaultValue) {
		String s = getPreference(key);
		if (StringUtils.isBlank(s))
			return defaultValue;
		else
			return Long.parseLong(s);
	}

	public static void setLongPreference(String key, long value) {
		setPreference(key, String.valueOf(value));
	}

	public static boolean getBooleanPreference(String key, boolean defaultValue) {
		String s = getPreference(key);
		if (StringUtils.isBlank(s))
			return defaultValue;
		else
			return Boolean.parseBoolean(s);
	}

	public static void setBooleanPreference(String key, boolean value) {
		setPreference(key, String.valueOf(value));
	}

	/**
	 * Load config.
	 * 
	 * @param file
	 *            the file
	 */
	public static void loadConfig(File file) {
		try {
			InputStream is = new FileInputStream(file);
			preferences.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * (这里用一句话描述这个方法的作用) replacePlaceHolder. (这里描述这个方法适用条件 – 可选)<br>
	 * (这里描述这个方法的执行流程 – 可选)<br>
	 * (这里描述这个方法的使用方法 – 可选)<br>
	 * (这里描述这个方法的注意事项 – 可选)<br>
	 * 
	 * @param message
	 *            the message
	 * @param params
	 *            the params
	 * @return the String
	 */
	private static String replacePlaceHolder(String message, String[] params) {
		if (StringUtils.isBlank(message))
			return message;
		if (params == null || params.length == 0)
			return message;

		Map<String, String> map = new HashMap<String, String>();
		int index = -1;

		Pattern p = Pattern.compile("\\{(\\d+)\\}");
		Matcher m = p.matcher(message);

		while (m.find()) {
			if (m.groupCount() < 1)
				continue;
			index = Integer.parseInt(m.group(1));
			if (index < 0 || index >= params.length)
				continue;

			map.put(m.group(0), params[index]);
		}

		if (map.isEmpty())
			return message;

		for (Entry<String, String> entry : map.entrySet()) {
			message = message.replace(entry.getKey(), entry.getValue());
		}

		return message;
	}
}
