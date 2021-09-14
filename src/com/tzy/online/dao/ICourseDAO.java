package com.tzy.online.dao;

import java.util.List;

import com.tzy.online.entity.Course;

/**
 * 课程信息
 * @author Administrator
 *
 */
public interface ICourseDAO {
	
	/**
	 * 获取所有课程
	 * @return
	 */
	public List<Course> findAll();
	
	/**
	 * 根据课程编号，显示课程详情
	 * @param id 课程编号
	 * @return 课程表对应数据
	 */
	public Course findById(int id);
	
	

}
