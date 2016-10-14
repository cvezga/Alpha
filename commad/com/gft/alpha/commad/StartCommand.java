package com.gft.alpha.commad;

import com.gft.alpha.Context;
import com.gft.alpha.service.AlphaService;

public class StartCommand implements AlphaCommand {

	@Override
	public String run(String[] args) {
		String alias = args[1];
		String className = Context.servicesMap.get(alias);
		if(className==null){
			className = alias;
		}
		
		try {
			AlphaService service = (AlphaService) Class.forName(className).newInstance();
			service.init(args);
			Thread t = new Thread(service);
			System.out.println("Starting service alias: "+alias+" class: "+className);
			t.start();
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
		
		return null;
	}

	@Override
	public String getCommandName() {
		return "start";
	}

}
