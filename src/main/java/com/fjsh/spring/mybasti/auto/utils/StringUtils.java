package com.fjsh.spring.mybasti.auto.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import com.fjsh.spring.mybasti.auto.db.Column;

/**
*@Title:StringUtil
*TODO:
*@Description: 字符串工具类
*@author:a925907195@qq.com
*@date 2016年10月30日 下午4:05:36
*
*/
public class StringUtils {

	/**
	 * 将列表转换为字符串并分割
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String listToString(List<Column> columns, char separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.size(); i++) {
			sb.append(columns.get(i).getJavaname()).append(separator);
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}
	/**
	 * 将列表转换为字符串并分割
	 * @param list
	 * @param separator
	 * @return
	 */
	public static String listToDBColumsString(List<Column> columns, char separator) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < columns.size(); i++) {
			sb.append(columns.get(i).getDbname()).append(separator);
		}
		return sb.toString().substring(0, sb.toString().length() - 1);
	}
	public static String listToStr(List<String> strList) {
		StringBuilder strBuilder = new StringBuilder("");
		try {
			if (null != strList && strList.size() > 0) {
				for (String str : strList) {
					strBuilder.append(str).append(",");
				}

				strBuilder.deleteCharAt(strBuilder.toString().lastIndexOf(","));
			}
		} catch (Exception e) {
			return null;
		}
		return strBuilder.toString();
	}

	public static String numInc(String numberStr) {
		if (null == numberStr || numberStr.length() == 0) {
			return "0";
		}
		return String.valueOf(Integer.valueOf(numberStr) + 1);
	}

	public static String trimRightZore(String numberStr) {
		if (numberStr == null || numberStr.length() == 0
				|| numberStr.indexOf('.') == -1) {
			return numberStr;
		}
		char[] chars = numberStr.toCharArray();
		StringBuilder sb = new StringBuilder(numberStr);
		// 依次去掉小数点右侧的'0'
		for (int i = chars.length - 1; i >= 0; i--) {
			if (chars[i] == '0') {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				break;
			}
			if (chars[i] == '.') {
				break;
			}
		}
		// 如果小数点右侧全是'0',那把小数点也去掉
		if (sb.charAt(sb.length() - 1) == '.') {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	/**
	 * 用户名隐藏显示
	 * 
	 * @param name
	 * @return
	 */
	public static String nameHide(String name) {
		if (name.length() <= 2) {
			char head = name.charAt(0);
			name = head + "***";
		} else {
			char head = name.charAt(0);
			char tail = name.charAt(name.length() - 1);
			name = head + "***" + tail;
		}
		return name;
	}

}
