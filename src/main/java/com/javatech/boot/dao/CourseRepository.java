package com.javatech.boot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.javatech.boot.entity.Course;


public interface CourseRepository extends JpaRepository<Course,Long> {
	
	//Custom finder method or derived query method
	 public List<Course> findByName(String name);
	 
	//Custom finder method or derived query method
	public List<Course> findByNameAndTitle(String name, String title);
	// using JPQL finding the all coures
	@Query("select u FROM Course u")
	public List<Course> getCoures();
	
	// using JPQL finding the all courses using name and title
	@Query("select u From Course u Where u.name=:n and u.title=:t") 
	public List<Course> getCourseByNameAndTitle(@Param("n")String name,@Param("t") String title);
	
	//Creating custom method based on Native query
	@Query(value="select * from course",nativeQuery=true)
	  public List<Course> getCoursesByNative();
	 
}
