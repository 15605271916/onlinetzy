package com.tzy.online.test;

import org.junit.Test;

import com.tzy.online.util.MD5Util;

public class Test06MD5 {
	
	@Test
	public void testMD5() {
		
		String str=MD5Util.MD5("123");
		
		System.out.println(str);
	}

}
