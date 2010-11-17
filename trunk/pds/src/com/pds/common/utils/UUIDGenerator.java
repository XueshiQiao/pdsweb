/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.common.utils;

import java.util.UUID;

/**
 * @author qiaoxueshi
 *
 */
public class UUIDGenerator {
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}
	
	public static String getUUID(String fromName){
		return UUID.fromString(fromName).toString();
	}
}
