package com.tzy.online.service.impl;

import java.util.List;

import com.tzy.online.entity.UserBase;
import com.tzy.online.vo.ApplyedCourse;

public interface IUserBaseService {

	/**
	 * 注册用户
	 * @param userBase
	 * @return 0没有保存成功;2账户已经存在;1保存成功
	 */
	public int reg(UserBase userBase);
	
	/**
	 * 用户登录
	 * @param account 账号
	 * @param pwd 密码
	 * @return
	 */
	public UserBase login(String account,String pwd);
	
	/**
	 * 申请课程
	 * @param account 用户名
	 * @param courseId 课程id
	 * @return
	 */
	public List<ApplyedCourse> applyCourse(String account,int courseId);
	
	
	
}
