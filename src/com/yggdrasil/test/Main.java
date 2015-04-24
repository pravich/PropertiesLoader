package com.yggdrasil.test;

import java.util.Enumeration;

public class Main {

	public static void main(String[] args) {
		System.out.println(Configuration.prop1);
		System.out.println(Configuration.prop2);
		System.out.println(Configuration.prop3);
		
		Enumeration e = Configuration.properties.keys();
		while(e.hasMoreElements()) {
			String key = (String)e.nextElement();
			System.out.println(key + "=" + Configuration.properties.get(key));
		}
	}

}
