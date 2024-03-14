package com.javaguides.springboot.Student;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/api/v1/students")
public class StudentController {
	private final StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping	
	public List <Student> getStudents(){
		return studentService.getStudents();
	}
	
	@PostMapping
	public Student registerNewStudents(@RequestBody Student student) {
		System.out.println("register student ***");
		studentService.addNewStudent(student);
		return student;
	}
	
	@DeleteMapping(path="{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
	studentService.deleteStudent(studentId);	
	}
	
	@PutMapping(path="{studentId}")
	public String updateStudent(
			@PathVariable("studentId") Long studentId, 
			@RequestParam (required=false) String name,
			@RequestParam(required=false) String email) 
	{
		studentService.updateStudent(studentId, name, email);
		System.out.println("####");
		return name;
	}
	
}
