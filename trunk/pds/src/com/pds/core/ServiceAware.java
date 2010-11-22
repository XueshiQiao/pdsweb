/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.core;

/**
 * @author qiaoxueshi
 *
 */
public interface ServiceAware<T> {
	public BaseService<T> getService();
}
