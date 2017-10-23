package com.bridgelabz.programs;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Course")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Course {
	@Id
	@GeneratedValue
	private int courseId;
	@Column(name="course")
	private String courseName;

	public Course(String courseName) {
		this.courseName = courseName;
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
