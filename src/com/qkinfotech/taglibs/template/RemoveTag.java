package com.qkinfotech.taglibs.template;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class RemoveTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String section;
	
	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public int doEndTag() throws JspException {
		UseTag parent = (UseTag)this.getParent();
		parent.addSectionContent(new SectionContent(section, Operation.remove, null));
		return super.doEndTag();
	}


}
