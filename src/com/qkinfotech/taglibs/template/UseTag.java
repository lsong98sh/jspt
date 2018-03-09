package com.qkinfotech.taglibs.template;

import java.util.HashMap;
import java.util.Stack;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class UseTag extends BodyTagSupport {

	private static final long serialVersionUID = 1L;
	
	private static final String SECTION_OPERATION_ATTR_NAME = "_$_SECTION_OPERATION_ATTR_NAME_$_";

	private String name;
	
	private String page;
	
	private HashMap<String, SectionContent> sections = new HashMap<String, SectionContent>();
	
	public void setName(String name) {
		this.name = name;
	}

	public void setPage(String page) {
		this.page = page;
	}
	
	@Override
	public int doStartTag() throws JspException {
		ServletRequest request = pageContext.getRequest();
		if(request.getAttribute(SECTION_OPERATION_ATTR_NAME) == null) {
			request.setAttribute(SECTION_OPERATION_ATTR_NAME, new Stack<HashMap<String, SectionContent>>());
		}
		return super.doStartTag();
	}

	public void addSectionContent(SectionContent sectionContent) {
		sections.put(sectionContent.getName(), sectionContent);
	}
	
	@Override
	public int doEndTag() throws JspException {
		ServletRequest request = pageContext.getRequest();
		Stack<HashMap<String, SectionContent>> stack = (Stack<HashMap<String, SectionContent>>)request.getAttribute(SECTION_OPERATION_ATTR_NAME);
		stack.push(sections);
		try {
			if(name != null) {
				String xpage = PageMap.getPage(pageContext, name);
				if(xpage != null) {
					page = xpage;
				}
			}
			if(page != null) {
				pageContext.include(page);
			}
		} catch (Exception e) {
			throw new JspException(e);
		} finally {
			stack.pop();
		}
		return super.doEndTag();
	}

	public static SectionContent getSectionContent(PageContext pageContext, String name) {
		ServletRequest request = pageContext.getRequest();
		Stack<HashMap<String, SectionContent>> stack = (Stack<HashMap<String, SectionContent>>)request.getAttribute(SECTION_OPERATION_ATTR_NAME);

		if(stack == null) {
			return null;
		}
		if(stack.isEmpty()) {
			return null;
		}
		return stack.peek().get(name);
	}


}
