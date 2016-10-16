package com.gft.alpha.net.handler;

import com.gft.alpha.Context;
import com.gft.alpha.vo.QueryService;

public class QueryServiceHandler implements ProtocolHandler {

	@Override
	public String getProtocolIdentifier() {
		return "query-request";
	}

	@Override
	public String process(String data) {
		String outcome = null;
		String source = data;
		QueryService qs = Context.qsMap.get(source);
		if(qs!=null){
			String handlerClassName = qs.getQueryHandlerClass();
			try {
				ProtocolHandler ph = (ProtocolHandler) Class.forName(handlerClassName).newInstance();
				outcome = ph.process(data);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return outcome;
	}

}
