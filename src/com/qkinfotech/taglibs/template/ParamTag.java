package com.qkinfotech.taglibs.template;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class ParamTag extends TagSupport {
	
	private static final long serialVersionUID = 1L;

	private String name;
	
	private String value;
	
	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int doEndTag() throws JspException {
		IncludeTag parent = ((IncludeTag)this.getParent());
		parent.addParam(name, value);
		return super.doEndTag();
	}

	

}
