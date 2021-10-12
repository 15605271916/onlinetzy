package com.tzy.online.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.tzy.online.entity.Course;
import com.tzy.online.service.CourseService;
import com.tzy.online.service.ICourseService;;

public class Test04CourseService {

	private ICourseService CourseService;

	@Before
	public void setUp() throws Exception {

		CourseService = new CourseService();

	}

	@Test
	public void testGetAll() {

		List<Course> courseList = CourseService.getAll();
		assertEquals(4, courseList.size());

		for (Course course : courseList) {
			String suffix = course.getImg();
			assertTrue(suffix.contains("png"));
		}
	}

}
