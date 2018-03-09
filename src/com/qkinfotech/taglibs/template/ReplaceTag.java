package com.qkinfotech.taglibs.template;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class ReplaceTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private String section;
	
	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public int doEndTag() throws JspException {
		
		UseTag parent = (UseTag)this.getParent();
		parent.addSectionContent(new SectionContent(section, Operation.replace, this.bodyContent.getString()));

		return super.doEndTag();
	}


}
