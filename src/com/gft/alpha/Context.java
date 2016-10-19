package com.gft.alpha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gft.alpha.vo.QueryService;
import com.gft.alpha.vo.ServiceProvider;
import com.gft.alpha.vo.VirtualMachine;

public class Context {
	
	/**
	public static String vmname;
	public static String ip;
	public static int port;
	public static String masterIp;
	public static int masterPort;
	**/
	
	public static Map<String, Object> varMap  = Collections.synchronizedMap( new HashMap<>() );
	
    public static Map<String, String> servicesMap = new HashMap<>();
    
    public static List<VirtualMachine> vmList = Collections.synchronizedList( new ArrayList<>() );
    
    public static List<String> sourceList = Collections.synchronizedList( new ArrayList<>() );
    
    public static Map<String, QueryService> providedServiceMap = Collections.synchronizedMap( new HashMap<>() );
    
    public static Map<String, List<QueryService> > subscriptionMap = Collections.synchronizedMap( new HashMap<>() );
    
    public static Map<String, List<ServiceProvider> > serviceProviderMap = Collections.synchronizedMap( new HashMap<>() );

    public static Map<String, String> pulseMap  = Collections.synchronizedMap( new HashMap<>() );
    
    public static void set(String key, Object value){
    	varMap.put(key, value);
    }
    
    public static Object get(String key){
    	return varMap.get(key);
    }
    
    public static String getString(String key){
    	return String.valueOf(varMap.get(key));
    }
    
    public static Integer getInteger(String key){
    	return Integer.parseInt(getString(key));
    }
    
    public static Long getLong(String key){
    	return (Long)get(key);
    }
}
