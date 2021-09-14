package com.tzy.online.ui;

import java.util.List;
import java.util.Scanner;

import com.tzy.online.entity.Course;
import com.tzy.online.entity.UserBase;
import com.tzy.online.enums.Gender;
import com.tzy.online.service.ICourseService;
import com.tzy.online.service.impl.CourseService;
import com.tzy.online.service.impl.IUserBaseService;
import com.tzy.online.service.impl.UserBaseService;
import com.tzy.online.util.ShareData;
import com.tzy.online.vo.ApplyedCourse;

public class MainUI {

	private ICourseService courseService = new CourseService();

	private IUserBaseService userBaseService = new UserBaseService();

//	private UserBase userBase;

	private Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.println("=====欢迎来到博为峰在线选课系统！=====");

		MainUI mainUI = new MainUI();

		mainUI.showMain();
	}

	/**
	 * 显示主页面
	 */
	public void showMain() {

		String loginReg = "4.登录\t5.注册";

		MainUI mainUI = new MainUI();

		if (ShareData.sessionUserBase != null) {

			loginReg = "欢迎：" + ShareData.sessionUserBase.getName() + "!";

		}

		System.out.println("1.查看所有课程\t2.课程详情\t3.申请课程\t" + loginReg + "\t6.退出");

		String flag = sc.next();

		switch (flag) {
		case "1":
			mainUI.showAllCourse();
			break;

		case "2":
			mainUI.showCourseDetail();
			break;

		case "3":
			mainUI.showApplyCourse();
			break;

		case "4":
			mainUI.showLogin();
			break;

		case "5":
			showReg();
			break;

		default:
			// 退出
			System.out.println("=====欢迎下次再来！ ©博为峰2021=====");
			System.exit(0);
			break;
		}
	}

	/**
	 * 显示所有课程
	 */
	public void showAllCourse() {
		// 调用业务层
		List<Course> courseList = courseService.getAll();

		System.out.print("编号");
		System.out.print("\t");
		System.out.print("课程名称");
		System.out.print("\t\t");
		System.out.print("价格");
		System.out.print("\t");
		System.out.println("开班时间");

		for (Course course : courseList) {

			System.out.print(course.getId());
			System.out.print("\t");
			System.out.print(course.getName());
			System.out.print("\t");
			System.out.print(course.getPrice());
			System.out.print("\t");
			System.out.println(course.getStartDate());

		}
		System.out.println("=====所有课程显示结束=====");

		showMain();
	}

	/**
	 * 显示课程详情
	 */
	public void showCourseDetail() {

		System.out.println("请输入课程编号");
		String ids = sc.nextLine();

		// 调用业务层
		Course course = courseService.detail(Integer.parseInt(ids));

		System.out.print("编号");
		System.out.print("\t");
		System.out.print("课程名称");
		System.out.print("\t\t");
		System.out.print("价格");
		System.out.print("\t");
		System.out.print("开班时间");
		System.out.print("\t\t");
		System.out.println("课程描述");

		try {
			System.out.print(course.getId());
			System.out.print("\t");
			System.out.print(course.getName());
			System.out.print("\t");
			System.out.print(course.getPrice());
			System.out.print("\t");
			System.out.print(course.getStartDate());
			System.out.print("\t");
			System.out.println(course.getDesc());
		} catch (Exception e) {
			System.out.println("查无此课程");
		}

		System.out.println("=====课程详情显示结束=====");

		showMain();

	}

	/**
	 * 显示注册页面
	 */
	public void showReg() {

		System.out.println("请输入账号：");
		String account = sc.next();

		System.out.println("请输入密码：");
		String pwd = sc.next();

		System.out.println("请输入姓名：");
		String name = sc.next();

		System.out.println("请输入性别：");
		String gender = sc.next();

		// 封装
		UserBase userBase = new UserBase();
		userBase.setAccount(account);
		userBase.setPwd(pwd);
		userBase.setName(name);
		if (gender.equals("0")) {
			userBase.setGender(Gender.MAN);
		} else {
			userBase.setGender(Gender.WOMAN);
		}

		// 调用业务层
		int count = userBaseService.reg(userBase);

		if (count == 1) {
			System.out.println("=====注册成功=====");
		} else if (count == 0) {
			System.out.println("=====注册失败=====");
		} else {
			System.out.println("=====账号已存在=====");
		}

		showMain();
	}

	/**
	 * 显示登录
	 */
	public void showLogin() {

		System.out.println("请输入账号：");
		String account = sc.nextLine();

		System.out.println("请输入密码：");
		String pwd = sc.nextLine();

		// 调用业务层
		UserBase userBase = userBaseService.login(account, pwd);

		if (userBase != null) {

			ShareData.sessionUserBase = userBase;

			System.out.println("=====登录成功=====");

		} else {

			System.out.println("=====账号密码不一致，请重新登陆=====");
		}

		showMain();
	}

	/**
	 * 显示申请
	 */
	public void showApplyCourse() {
		
		List<ApplyedCourse> applyedCourseList=null;

		// 申请之前判断用户是否已经登录
		if (ShareData.sessionUserBase == null) {

			System.out.println("=====请先登录=====");

		} else {

			System.out.println("请输入要申请课程的编号");

			String courseId = sc.nextLine();

			String account = ShareData.sessionUserBase.getAccount();

			// 调用业务层
			applyedCourseList= userBaseService.applyCourse(account, Integer.parseInt(courseId));

			if (applyedCourseList != null) {
				
				System.out.print("申请编号");
				System.out.print("\t");
				
				System.out.print("课程名");
				System.out.print("\t\t");
				
				System.out.print("申请时间");
				System.out.print("\t\t");
				
				System.out.println("状态");
				
				for (ApplyedCourse applyedCourse : applyedCourseList) {
					
					System.out.print(applyedCourse.getApplyId());
					System.out.print("\t");
					
					System.out.print(applyedCourse.getCourseName());
					System.out.print("\t");
					
					System.out.print(applyedCourse.getApplyDate());
					System.out.print("\t");
					
					System.out.println(applyedCourse.getFlag());
					
				}
				
				System.out.println("=====申请成功=====");

			} else {

				System.out.println("=====申请失败=====");
			}
		}
		
		
		
		
		//显示已经申请的课程列表
		
		
		

		showMain();

	}
}
