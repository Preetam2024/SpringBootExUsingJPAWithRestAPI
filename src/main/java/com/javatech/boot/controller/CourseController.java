package com.javatech.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatech.boot.entity.Course;
import com.javatech.boot.services.CourseService;

import java.util.*;

@RestController
public class CourseController {
	@Autowired
	private CourseService courseService;

	// Get All courses
	@GetMapping("/courses")
	public List<Course> getAllCourse() {
		return this.courseService.getAllCourses();

	}

	// course add
	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);

	}

	// update course
	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) {
		return this.courseService.updateCourse(course);
	}

	// delete course
	@DeleteMapping("/course/{courseId}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		try {
			this.courseService.deleteCourse(Long.parseLong(courseId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// calling custom finder method with name
	@GetMapping("/courses/{name}")
	public List<Course> getByName(@PathVariable String name) {
		return this.courseService.findByName(name);

	}
	// Calling custom finder method with name and title

	@GetMapping("/course")
	public List<Course> getByNameAndTitle(@RequestParam String name, @RequestParam String title) {

		return this.courseService.getByNameAndTitle(name, title);

	}

	// Finding the data using JPQL
	@GetMapping("/allCoures")
	public List<Course> getCoures() {
		return this.courseService.getCoures();

	}

	// Finding the data using JPQL
	@GetMapping("/getCoures")
	public List<Course> getCourseByNameAndTitle(@RequestParam String name, @RequestParam String title) {
		return this.courseService.getCourseByNameAndTitle(name, title);
	}

	// Find the courses using native query
	@GetMapping("/getCouresNative")
	public List<Course> getCoursesByNative() {
		return this.courseService.getCoursesByNative();
	}
}