package com.gft.alpha;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gft.alpha.vo.VirtualMachine;

public class Context {
	
	public static String vmname;
	public static String ip;
	public static String masterIp;
	public static int masterPort;
	
    public static Map<String, String> servicesMap = new HashMap<>();
    
    public static List<VirtualMachine> vmList = Collections.synchronizedList( new ArrayList<>());
    
    
    

}
