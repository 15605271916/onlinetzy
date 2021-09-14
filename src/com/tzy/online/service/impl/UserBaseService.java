package com.tzy.online.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.tzy.online.dao.IUserBaseDAO;
import com.tzy.online.dao.impl.UserBaseDAO;
import com.tzy.online.entity.UserBase;
import com.tzy.online.util.DBHelp;
import com.tzy.online.util.MD5Util;
import com.tzy.online.vo.ApplyedCourse;

public class UserBaseService implements IUserBaseService {

	private IUserBaseDAO userBaseDAO;

	public UserBaseService() {

		userBaseDAO = new UserBaseDAO();
	}

	@Override
	public int reg(UserBase userBase) {

		// 判断用户是否已经存在
		if (userBaseDAO.findByAccount(userBase.getAccount()) != null) {

			// 说明用户已经存在
			return 2;
		}

		// 加密
		String pwd = userBase.getPwd();
		pwd = MD5Util.MD5(pwd);
		userBase.setPwd(pwd);

		int count = userBaseDAO.save(userBase);

		return count;
	}

	@Override
	public UserBase login(String account, String pwd) {
		
		pwd = MD5Util.MD5(pwd);

		UserBase userBase = userBaseDAO.findBy(account, pwd);

		return userBase;
	}

	@Override
	public List<ApplyedCourse> applyCourse(String account, int courseId) {
		
		//判断此用户是否已经申请此课程
		
		//申请
		int count=userBaseDAO.saveMyCourse(account, courseId);
		
		if(count==1) {
			
			//查询
			List<ApplyedCourse> applyedCourseList=userBaseDAO.findMyApplyed(account);
			
			return applyedCourseList;
			
		}else {
			
			return null;
		}
		
		
	}

}
