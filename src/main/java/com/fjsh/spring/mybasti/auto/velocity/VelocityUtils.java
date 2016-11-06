package com.fjsh.spring.mybasti.auto.velocity;

import java.io.StringWriter;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

import com.fjsh.spring.mybasti.auto.utils.IConstants;

public class VelocityUtils {
	private static Log log = LogFactory.getLog(VelocityUtils.class);
	static {
		try {
			Velocity.init(IConstants.VELOCITY_PROPERTIES);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error(e);
			//e.printStackTrace();
		}
	}
	public static String mergeTemplate(Map<String, Object> contextmap,
			String templatepath) {
		StringWriter sw = new StringWriter(1000);
		try {
			
			Template template = Velocity.getTemplate(templatepath,"UTF-8");
			Context context = new VelocityContext(contextmap);
			template.merge(context, sw);
			//sw.flush();
		} catch (Exception ex) {
			log.error(ex);
			//ex.printStackTrace();
		}
		return sw.toString();
	}
	


}
