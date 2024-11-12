package com.javatech.boot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Course {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String title;
	private String description;
	
	//private Student Student;
	public Course(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", title=" + title + ", description=" + description + "]";
	}
	
	

}
