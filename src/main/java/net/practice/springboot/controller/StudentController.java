package net.practice.springboot.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.practice.springboot.exception.ResourceNotFoundException;
import net.practice.springboot.model.Student;
import net.practice.springboot.repository.StudentRepository;

@RestController
@RequestMapping("/api/v1/")
public class StudentController {
	
	
	@Autowired
	private StudentRepository studentRepository;
	
	//get students
	@GetMapping("students")
	public List<Student> getAllStudent(){
		return this.studentRepository.findAll();
	}
	
	
	//get student by id
	@GetMapping("students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long studentId)
	throws ResourceNotFoundException{
		Student student =studentRepository.findById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("Employee not found for this id :: " + studentId));
				return ResponseEntity.ok().body(student);
	}
	
	
	
	//save student
	@PostMapping("students")
	public Student createStudent(@RequestBody Student student) {
		return this.studentRepository.save(student);
	}
	
	
	//update student
	@PutMapping("students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id")Long studentId,
			@RequestBody Student studentDetails) throws ResourceNotFoundException{
		Student student =studentRepository.findById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("Employee not found for this id :: " + studentId));
				student.setEmail(studentDetails.getEmail());
				student.setFirstName(studentDetails.getFirstName());
				student.setLastName(studentDetails.getLastName());
				return ResponseEntity.ok(this.studentRepository.save(student));
	}
	
	
	//delete student
	@DeleteMapping("students/{id}")
	public Map<String,Boolean> deleteStudent(@PathVariable(value="id")Long studentId) throws ResourceNotFoundException{
		Student student =studentRepository.findById(studentId)
				.orElseThrow(()->new ResourceNotFoundException("Employee not found for this id :: " + studentId));
				this.studentRepository.delete(student);
				Map<String,Boolean> response=new HashMap<>();
				response.put("deleted", Boolean.TRUE);
				return response;
	}
}
