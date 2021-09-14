package com.tzy.online.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tzy.online.dao.ICourseDAO;
import com.tzy.online.dao.impl.CourseDAO;
import com.tzy.online.entity.Course;

public class Test03CourseDAO {

	private ICourseDAO courseDAO;

	@Before
	public void setUp() {

		courseDAO = new CourseDAO();

	}

	@Test
	public void testFindAll() {

		List<Course> courseList = courseDAO.findAll();

		assertEquals(4, courseList.size());

	}

	@Test
	public void testFindById() {

		Course course = courseDAO.findById(1);

		assertNotNull(course);

	}

}
