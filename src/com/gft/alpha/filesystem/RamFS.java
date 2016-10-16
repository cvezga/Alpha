package com.gft.alpha.filesystem;

import java.util.HashMap;
import java.util.Map;

public class RamFS {

	private RamFile currentPath;

	private Map<String, RamFile> pathMap = new HashMap<>();

	public RamFS() {
		
            mkdir("/");
            mkdir("/bin");
            mkdir("/script");
            mkdir("/tmp");
            
            this.currentPath = pathMap.get("/");
            
	}

	private void mapTerminalCommand(String cmdName, String className){
		RamFile p = mkdir("/bin/"+cmdName);
		
			p.write(className);
			
			
	}
	
;
	public RamFile mkdir(String path) {
		RamFile newPath = new RamFile(path);
		pathMap.put(path,  newPath);
		
		
		return newPath;
	}
	
	public static void main(String[] args) {
		RamFS rfs = new RamFS();
	}
}
