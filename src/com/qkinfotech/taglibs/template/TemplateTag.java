package com.qkinfotech.taglibs.template;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class TemplateTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	@Override
	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = this.getPreviousOut();
        try {  
            out.print(this.getBodyContent().getString());  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
		return super.doEndTag();
	}


}
