package com.tzy.online.service.impl;

import java.util.Iterator;
import java.util.List;

import com.tzy.online.dao.ICourseDAO;
import com.tzy.online.dao.impl.CourseDAO;
import com.tzy.online.entity.Course;
import com.tzy.online.service.ICourseService;

public class CourseService implements ICourseService {
	
	private ICourseDAO courseDAO;
	
	public CourseService() {
		
		courseDAO=new CourseDAO();
	}

	@Override
	public List<Course> getAll() {
		
		List<Course> courseList=courseDAO.findAll();

		for (Iterator<Course> it = courseList.iterator(); it.hasNext();) {
			Course course = (Course) it.next();
			course.setImg(course.getImg()+".png");
		}
		
		return courseList;
	}

	@Override
	public Course detail(int id) {
		
		Course course= courseDAO.findById(id);
		
		return course;
	}

}
