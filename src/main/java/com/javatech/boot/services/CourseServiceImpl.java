package com.javatech.boot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatech.boot.dao.CourseRepository;
import com.javatech.boot.entity.Course;
@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepo;
	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courseRepo.findAll();
	}

	@Override
	public Course getCourse(long courseId) {
		// TODO Auto-generated method stub
		return courseRepo.getOne(courseId);
		//courseRepo.getById(courseId);
	}
	

	@Override
	public Course addCourse(Course course) {
		// TODO Auto-generated method stub
		 courseRepo.save(course);
		 return course;
	}

	@Override
	public Course updateCourse(Course course) {
		// TODO Auto-generated method stub
		courseRepo.save(course);
		return course;
	}

	@Override
	public void deleteCourse(long parseLong) {
		// ODO Auto-generated method stub
		Course entity=courseRepo.getOne(parseLong);
		courseRepo.delete(entity);
		
	}

	@Override
	public List<Course> findByName(String name) {
		return courseRepo.findByName(name);
		// TODO Auto-generated method stub
	}

	@Override
	public List<Course> getByNameAndTitle(String name, String title) {
		// TODO Auto-generated method stub
		return courseRepo.findByNameAndTitle(name, title);
	}

	@Override
	public List<Course> getCoures() {
		// TODO Auto-generated method stub
		return courseRepo.getCoures();
	}

	@Override
	public List<Course> getCourseByNameAndTitle(String name, String title) {
		// TODO Auto-generated method stub
		return courseRepo.getCourseByNameAndTitle(name, title);
	}

	@Override
	public List<Course> getCoursesByNative() {
		// TODO Auto-generated method stub
		return courseRepo.getCoursesByNative();
	}



}
