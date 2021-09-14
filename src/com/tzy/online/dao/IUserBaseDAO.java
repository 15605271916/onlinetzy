package com.tzy.online.dao;

import java.util.List;

import com.tzy.online.entity.UserBase;
import com.tzy.online.vo.ApplyedCourse;

public interface IUserBaseDAO {
	
	/**
	 * 保存用户
	 * @param userBase
	 * @return
	 */
	public int save(UserBase userBase);
	
	
	/**
	 * 根据账号得到用户信息
	 * @param account
	 * @return
	 */
	public UserBase findByAccount(String account);
	
	/**
	 * 根据账号密码得到用户信息
	 * @param account 账号
	 * @param pwd 密码
	 * @return
	 */
	public UserBase findBy(String account,String pwd); 
	
	/**
	 * 申请课程
	 * @param account 用户
	 * @param courseId 课程编号
	 * @return
	 */
	public int saveMyCourse(String account,int courseId);
	
	/**
	 * 根据账号得到申请的课程
	 * @param account 账号
	 * @return
	 */
	public List<ApplyedCourse> findMyApplyed(String account);

}
