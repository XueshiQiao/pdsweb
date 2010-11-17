/**
 * BY qiaoxueshi at pingdingshan university
 */
package com.pds.common.page;

import java.util.ArrayList;

/**
 * @author qiaoxueshi
 *
 */
public class TestPageModel {
	public static void main(String[] args) {
		Paginable<Object> pageModel = new PageModel<Object>(new ArrayList<Object>(), 100, -1, 10);
		System.out.println(pageModel);
	}
}
