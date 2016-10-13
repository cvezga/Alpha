package com.gft.alpha.router;

public class Query {
	
	private String sourceName;

	public Query(String sourceName) {
		this.sourceName = sourceName;
	}

	public String run() {
		
		String ip = Router.getSourceIp(this.sourceName);
		
		if(ip==null){
			System.out.println("Warning: Unkown source "+this.sourceName);
			return "Source Unkown";
		}
		
		SocketClient client = new SocketClient(ip);
		
		String response = client.getSourceData(this.sourceName);
		
		return response;
	}

}
