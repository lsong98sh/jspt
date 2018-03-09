package com.qkinfotech.taglibs.template;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.jsp.PageContext;

public class PageMap {
	private static String filenkey = "PageMapFilePath";

	private static String filename = "WEB-INF/template.properties";

	private static Properties map = null;

	public static String getPage(PageContext pageContext, String name) {
		synchronized (filename) {
			if (map == null) {
				String fname = pageContext.getRequest().getServletContext().getInitParameter(filenkey);
				if (fname == null) {
					fname = filename;
				}
				map = new Properties();
				try {
					InputStream is = pageContext.getRequest().getServletContext().getResourceAsStream(fname);
					if (is != null) {
						map.load(is);
					}
				} catch (Exception e) {
				}
			}
		}

		return map.getProperty(name);
	}

}
