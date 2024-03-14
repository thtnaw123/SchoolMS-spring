package com.javaguides.springboot.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
@Service
public class StudentService {
	
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public List <Student> getStudents() {
		 return studentRepository.findAll();
		}

	public void addNewStudent(Student student) {
		System.out.println("$$"+student);
		Optional <Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
		
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		studentRepository.save(student);
		
		System.out.println("student");
	}

	public void deleteStudent(Long studentId) {
		boolean exists =studentRepository.existsById(studentId);
		
		if (!exists) {
			throw new IllegalStateException("student with id"+ studentId+" does not exists.");
		}
		studentRepository.deleteById(studentId);
		
	}

	@Transactional
	public void updateStudent(Long studentId, String name, String email) {
		Student student = studentRepository.findById(studentId)
				.orElseThrow(()->  new IllegalStateException("student with id"+ studentId + "does not exist") );
		
		System.out.println("####");

		if (name != null  && name.length() > 0 && !Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		
		if (email != null  && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
			
			Optional <Student> studentOptional = studentRepository.findStudentByEmail(email);
			
			if (studentOptional.isPresent()) {
				throw new IllegalStateException("email taken");
			}
			 
			student.setEmail(email);
		}
		
		
		
	}
	
	
}




//
//public List <Student> getStudents() {
//	 return List.of(
//			 new Student (1L, "Mariam", "M@gmail.com", LocalDate.of(2002, 03, 11), 23)
//			 );
//	}