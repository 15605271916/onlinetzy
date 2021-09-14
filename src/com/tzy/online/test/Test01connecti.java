package com.tzy.online.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import com.tzy.online.entity.UserBase;

public class Test01connecti {
	
	@Before
	public void setUp() {
		
	}
	
	
	@org.junit.Test
	public void testList() {
		
		List<UserBase> list=new ArrayList<UserBase>();
		
		UserBase ub1=new UserBase();
		ub1.setId(1);
		ub1.setAccount("zhangsan");
		ub1.setName("张三");
		
		UserBase ub2=new UserBase();
		ub2.setId(2);
		ub2.setAccount("lisi");
		ub2.setName("李四");

		list.add(ub1);
		list.add(ub2);
		
		System.out.println(list);
		
	}

}
