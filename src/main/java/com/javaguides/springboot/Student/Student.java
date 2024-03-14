package com.javaguides.springboot.Student;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
//import org.hibernate.annotations.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Transient;


@Entity

//@Table(appliesTo = "Student")

public class Student {

	@Id
	
	@SequenceGenerator(
			name="student_sequence",
			sequenceName="student_sequence",
			allocationSize=1
			)	
	
	@GeneratedValue(
			strategy= GenerationType.SEQUENCE,
			generator= "student_sequence"
		)
	
	private Long id;
	
	@Column(name="name", nullable=false, columnDefinition="TEXT")

	private String name;
	private String email;
	private LocalDate dob;
	
	@Transient
	private Integer age;
	
	
	  public Student() {
	    }
	public Student(Long id, String name, String email, LocalDate dob ) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.dob = dob;
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public Integer getAge() {
		
		return Period.between(this.dob, LocalDate.now()).getYears();
	}
	
	@Override
	public String toString() {
	    return "Student{" +
	            "id=" + id +
	            ", name='" + name + '\'' +
	            ", email='" + email + '\'' +
	            ", dob=" + dob +
	            ", age=" + age +
	            '}';
	}

	
	
}
