package com.javatech.boot.services;

import java.util.List;

import com.javatech.boot.entity.Course;

public interface CourseService {
	public List<Course> getAllCourses();
	
	public Course getCourse(long courseId);
	
	public Course addCourse(Course course);
	
	public Course updateCourse(Course course);
	
	public void deleteCourse(long parseLong);
	//Custome Finder method with Name
	public List<Course> findByName(String name);
	//Custome Finder method with Name and Title
	public List<Course> getByNameAndTitle(String name,String title);

	public List<Course> getCoures();

	public List<Course> getCourseByNameAndTitle(String name, String title);

	public List<Course> getCoursesByNative();
	
}
