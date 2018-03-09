package com.qkinfotech.taglibs.template;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class IncludeTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private HashMap<String, String> params = new HashMap<String, String>();
	
	private String name;
	
	private String page;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public void addParam(String name, String value) {
		params.put(name, value);
	}
	

	@Override
	public int doStartTag() throws JspException {
		params.clear();
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		try {
			if(name != null) {
				String xpage = PageMap.getPage(pageContext, name);
				if(xpage != null) {
					page = xpage;
				}
			}
			if(page != null) {
				String enc = pageContext.getRequest().getCharacterEncoding();
				if(enc == null) {
					enc = "UTF-8";
				}
				String url = page;
				StringBuilder param = new StringBuilder();
				for(Entry<String, String> entry : params.entrySet()) {
					param.append("&");
					param.append(URLEncoder.encode(entry.getKey(), enc));
					param.append("=");
					param.append(URLEncoder.encode(entry.getValue(), enc));
				}
				if(param.length() > 0) {
					if(url.indexOf('?') < 0) {
						param.setCharAt(0, '?');
					}
					url += param.toString(); 
				}
				pageContext.include(url);
			}
		} catch (Exception e) {
			throw new JspException(e);
		}
		return super.doEndTag();
	}
}
