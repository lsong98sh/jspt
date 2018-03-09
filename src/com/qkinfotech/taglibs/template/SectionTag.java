package com.qkinfotech.taglibs.template;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class SectionTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int doStartTag() throws JspException {
		return super.doStartTag();
	}

	@Override
	public int doEndTag() throws JspException {
        try {  
			SectionContent sectionContent = UseTag.getSectionContent(pageContext, name);
			JspWriter out = this.getPreviousOut(); 
			if(sectionContent == null) {
	            out.print(this.getBodyContent().getString());  
			}else if(sectionContent.getOperation() == Operation.prepend) {
	            out.print(sectionContent.getBodyContent());  
	            out.print(this.getBodyContent().getString());  
			} else if(sectionContent.getOperation() == Operation.append) {
	            out.print(this.getBodyContent().getString());  
	            out.print(sectionContent.getBodyContent());  
			} else if(sectionContent.getOperation() == Operation.replace) {
	            out.print(sectionContent.getBodyContent());  
			}
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
		return super.doEndTag();
	}
}
