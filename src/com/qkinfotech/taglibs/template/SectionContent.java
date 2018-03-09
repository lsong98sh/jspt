package com.qkinfotech.taglibs.template;

public class SectionContent {
	
	private String name;
	
	private String bodyContent;
	
	private Operation operation;

	public SectionContent(String name, Operation operation, String bodyContent) {
		super();
		this.name = name;
		this.bodyContent = bodyContent;
		this.operation = operation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBodyContent() {
		return bodyContent;
	}

	public void setBodyContent(String bodyContent) {
		this.bodyContent = bodyContent;
	}

	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
	

}
