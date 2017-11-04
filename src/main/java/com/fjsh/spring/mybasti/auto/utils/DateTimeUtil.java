package com.fjsh.spring.mybasti.auto.utils;

import org.apache.commons.lang.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
*@Title:DateTimeUtil
*TODO:
*@Description: 时间格式化工具
*@author:a925907195@qq.com
*@date 2016年10月30日 下午2:31:38
*
*/
public class DateTimeUtil {

	public static final String FORMAT_DEFAULT_MIN = "yyyyMMddHHmmss";
	/**
	 * 时间格式2016-07-18 21:45::12
	 * */
	public static final String FORMAT_DEFAULT = "yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_YMDHM = "yyyy-MM-dd HH:mm";
	public static final String FORMAT_DEFAULT_CH = "yyyy年MM月dd日 HH时mm分ss秒";

	/**
	 * 时间格式2016-07-18
	 * */
	public static final String FORMAT_DEFAULT_YMD = "yyyy-MM-dd";

	/**
	 * 时间格式20160718
	 * */
	public static final String FORMAT_YMD = "yyyyMMdd";

	public static final String FORMAT_HMS = "HH:mm:ss";
	public static final String FORMAT_YMDHM_DOT = "yyyy.MM.dd HH:mm";
	public static final String FORMAT_YMDHM_DIAGONAL = "yyyy/MM/dd HH:mm";
	
	public static final long SECOND_MILLI = 1000;
	public static final long MINUTE_SECOND = 60;
	public static final long HOUR_SECOND = 60 * MINUTE_SECOND; 	//3600
	public static final long DAY_SECOND = 24 * HOUR_SECOND;		//86400

	public static Date current() {
		return new Date();
	}

	public static Integer[] getYMDHMS(Date date) {
		Calendar cal = getCalendar(date);

		return new Integer[] { cal.get(Calendar.YEAR),
				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH),
				cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),
				cal.get(Calendar.SECOND) };
	}

	public static Integer getWeekOfMonth(Date date) {
		Calendar cal = getCalendar(date);

		return cal.get(Calendar.WEEK_OF_MONTH);
	}

	/**
	 * 取本周周一的日期(周一为一周第一天)
	 * 
	 * @param date
	 * @return
	 */
	public static Date thisWeekMonday(Date date) {
		Calendar cal = getCalendar(date);
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		return cal.getTime();
	}

	/**
	 * 返回星期数（周日返回7）
	 * 
	 * @param date
	 * @return
	 */
	public static int getDayOfWeek(Date date) {
		Calendar cal = getCalendar(date);
		int re = cal.get(Calendar.DAY_OF_WEEK);

		if (re == 0) {
			return 7;
		} else {
			return re - 1;
		}
	}

	public static Date addSecond(Date date, int num) {
		return add(date, Calendar.SECOND, num);
	}

	public static Date addMinute(Date date, int num) {
		return add(date, Calendar.MINUTE, num);
	}

	public static Date addHour(Date date, int num) {
		return add(date, Calendar.HOUR_OF_DAY, num);
	}

	public static Date addDay(Date date, int num) {
		return add(date, Calendar.DAY_OF_MONTH, num);
	}

	public static Date add(Date date, int field, int num) {
		Calendar cal = getCalendar(date);
		cal.add(field, num);

		return cal.getTime();
	}

	public static Date firstOfMonth(Date date) {
		return first(date, Calendar.DAY_OF_MONTH);
	}

	public static Date lastOfMonth(Date date) {
		return last(date, Calendar.DAY_OF_MONTH);
	}

	public static Date firstOfHour(Date date) {
		return first(date, Calendar.HOUR_OF_DAY);
	}

	public static Date lastOfHour(Date date) {
		return last(date, Calendar.HOUR_OF_DAY);
	}

	public static Date first(Date date, int d) {
		if (null == date) {
			return date;
		}

		Calendar cal = getCalendar(date);
		cal.set(d, cal.getMinimum(d));

		return cal.getTime();
	}

	public static Date last(Date date, int d) {
		if (null == date) {
			return date;
		}

		Calendar cal = getCalendar(date);
		cal.set(d, cal.getMaximum(d));

		return cal.getTime();
	}

	public static Calendar getCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);

		return cal;
	}

	public static String dateToStrOfYmdFormat(Date date) {
		return dateToStr(date, FORMAT_DEFAULT_YMD);
	}
	
	public static String dateToStrOfYmdHmsFormat(Date date) {
		return dateToStr(date, FORMAT_DEFAULT_MIN);
	}

	public static String dateToStrOfDefaulfFormat(Date date) {
		return dateToStr(date, FORMAT_DEFAULT);
	}

	public static String dateToStrOfYMDHMFormat(Date date) {
		return dateToStr(date, FORMAT_YMDHM);
	}
	
	public static String dateToStrOfHMSFormat(Date date) {
		return dateToStr(date, FORMAT_HMS);
	}
	
	public static String dateToStrOfYMDHMDotFormat(Date date) {
		return dateToStr(date, FORMAT_YMDHM_DOT);
	}

	public static String dateToStrOfYMDHMDiagonalFormat(Date date) {
		return dateToStr(date, FORMAT_YMDHM_DIAGONAL);
	}
	
	/**long型时间戳格式转换为格式化的年月日时分秒格式字符串
	 * @param date
	 * @return
	 */
	public static String longToStrOfDefaulfFormat(long date) {
		return dateToStrOfDefaulfFormat(new Date(date));
	}
	
	/**long型时间戳格式转换为格式化的年月日时分秒格式字符串
	 * @param date
	 * @return
	 */
	public static String longToStrOfYMDHMFormat(long date) {
		return dateToStrOfYMDHMFormat(new Date(date));
	}

	/**
	 * 获取注册的天数
	 * @param date
	 * @return
	 */
	public static String getRegDays(Date date) 
	{
		if(date==null)
		{
			return "0天";
		}
		else {
			  try {
				SimpleDateFormat sdf=new SimpleDateFormat(FORMAT_DEFAULT_YMD);  
				  try {
					date=sdf.parse(sdf.format(date));
				} catch (ParseException e) {

					e.printStackTrace();
				}  
				  Date datecurr=new Date();
				  try {
					datecurr=sdf.parse(sdf.format(datecurr));
				} catch (ParseException e) {

					e.printStackTrace();
				}  
				    Calendar cal = Calendar.getInstance();    
				    cal.setTime(date);    
				    long time1 = cal.getTimeInMillis();                 
				    cal.setTime(datecurr);    
				    long time2 = cal.getTimeInMillis();         
				    long between_days=(time2-time1)/(1000*3600*24);  
				        
				   return (Integer.parseInt(String.valueOf(between_days))+1)+"天";
			} catch (NumberFormatException e) {

				return "0天";
			}  			
		}
	}

	/**
	 * 日期转换为制定的字符串格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToStr(Date date, String format) {
		if (null == date) {
			return "";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		return sdf.format(date);
	}

	public static Date strToDateOfYmdFormat(String dateStr) {
		return strToDate(dateStr, FORMAT_DEFAULT_YMD);
	}

	public static Date strToDateOfDefaulfFormat(String dateStr) {
		return strToDate(dateStr, FORMAT_DEFAULT);
	}

	/**
	 * 字符串转换为日期类型
	 * 
	 * @param dateStr
	 * @param format
	 * @return
	 */
	public static Date strToDate(String dateStr, String format) {
		if (null == dateStr || StringUtils.isEmpty(dateStr)) {
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);

		try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			// e.printStackTrace();
		}

		return null;
	}

	/**
	 * 计算两日期间相差天数.
	 * 
	 * 
	 * @param d1
	 *            开始日期 日期型
	 * @param d2
	 *            结束日期 日期型
	 * @return long 天数
	 */
	public static long signDaysBetweenTowDate(Date d1, Date d2) {
		return (d2.getTime() - d1.getTime()) / (3600 * 24 * 1000);
	}

	/**
	 * 获取2个日期("yyyy-MM-dd")之间的所有日期
	 * 
	 * @param d1
	 * @param d2
	 * @return GregorianCalendar[]
	 * @throws ParseException
	 */
	public static Calendar[] getBetweenDate(String d1, String d2) {
		List<GregorianCalendar> v = new ArrayList<GregorianCalendar>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();

		try {
			gc1.setTime(sdf.parse(d1));
			gc2.setTime(sdf.parse(d2));

			do {
				GregorianCalendar gc3 = (GregorianCalendar) gc1.clone();
				v.add(gc3);
				gc1.add(Calendar.DAY_OF_MONTH, 1);
			} while (!gc1.after(gc2));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return v.toArray(new GregorianCalendar[v.size()]);
	}

	/**
	 * 获取2个日期("yyyy-MM-dd")之间的所有日期
	 * 
	 * @param d1
	 * @param d2
	 * @return GregorianCalendar[]
	 * @throws ParseException
	 */
	public static Calendar[] getBetweenDate(Date d1, Date d2) {
		List<GregorianCalendar> v = new ArrayList<GregorianCalendar>();
		Calendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
		gc1.setTime(d1);
		gc2.setTime(d2);

		do {
			GregorianCalendar gc3 = (GregorianCalendar) gc1.clone();
			v.add(gc3);
			gc1.add(Calendar.DAY_OF_MONTH, 1);
		} while (!gc1.after(gc2));

		return v.toArray(new GregorianCalendar[v.size()]);
	}
	
	/**
	 * 当前天的起始时间
	 */
	public static Date getDayStart() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 当前天的结束时间
	 */
	public static Date getDayEnd() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(DateTimeUtil.addDay(new Date(), 1));

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	/**
	 * 本周的起始时间
	 */
	public static Date getWeekStart() {
		Calendar calendar = Calendar.getInstance();

		calendar.set(calendar.get(Calendar.YEAR), 
				calendar.get(Calendar.MONDAY), 
				calendar.get(Calendar.DAY_OF_MONTH), 
				0, 0, 0);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);

		return calendar.getTime();
	}

	/**
	 * 本周的结束时间
	 */
	public static Date getWeekEnd() {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(getWeekStart());
		calendar.add(Calendar.DAY_OF_WEEK, 7);

		return calendar.getTime();
	}

	public String checkDateDefaulfFormat(String dateStr) {		
		if (StringUtils.isEmpty(dateStr)) {
			return "";
		} else if (Pattern.compile("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}:\\d{2}").matcher(dateStr).matches()) {
			return dateStr;
		} else if (Pattern.compile("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}:\\d{2}").matcher(dateStr).matches()) {
			return dateStr + ":00";
		} else if (Pattern.compile("\\d{4}-\\d{2}-\\d{2}\\s\\d{2}").matcher(dateStr).matches()) {
			return dateStr + ":00:00";
		} else {
			return "";
		}
	}

	//把时间单位为ms的long型时间改成0'00''的格式
	public static String long2MinsSeconds(long time) {
		if(time > 0) {
			int minutes = (int)time/(1000*60);
			int seconds = (int)time%(1000*60);
			return ""+minutes+"'"+(seconds <10? "0":"")+seconds+"''";
		}

		return "";
	}

	//把时间单位为s的long型时间改成0'00''的格式
	public static String seconds2MinsSeconds(long time) {
		if(time > 0) {
			int minutes = (int)time/60;
			int seconds = (int)time%60;
			return ""+minutes+"'"+(seconds <10? "0":"")+seconds+"''";
		}

		return "";
	}
}
