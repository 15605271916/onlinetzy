package com.tzy.online.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.tzy.online.dao.IUserBaseDAO;
import com.tzy.online.dao.impl.UserBaseDAO;
import com.tzy.online.entity.UserBase;
import com.tzy.online.enums.Gender;

public class Test05UserBaseDAO {
	
	private IUserBaseDAO userBaseDAO;
	private UserBase userBase;
	
	@Before
	public void setUp() {
		
		userBaseDAO=new UserBaseDAO();
		userBase=new UserBase();
		
		userBase.setAccount("zhangsan");
		userBase.setName("张三");
		userBase.setPwd("123");
		userBase.setGender(Gender.WOMAN);
	}
	
	@Test
	public void testSave() {
		
		int count=userBaseDAO.save(userBase);
		assertEquals(1, count);
	}

}
