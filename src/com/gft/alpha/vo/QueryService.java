package com.gft.alpha.vo;

public class QueryService {

	private String source;
	private String queryHandlerClass;

	public QueryService(String source, String queryHandlerClass) {
		super();
		this.source = source;
		this.queryHandlerClass = queryHandlerClass;
	}

	public String getSource() {
		return source;
	}

	public String getQueryHandlerClass() {
		return queryHandlerClass;
	}

}
