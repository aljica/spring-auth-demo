package com.auth.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

  private final StudentService studentService;

  @Autowired
  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }
  
  @GetMapping(value="getStudents")
	public List<Student> getStudents(HttpServletRequest request) {
		return studentService.getStudents();
	}

  @PostMapping(value="addStudent")
  public void registerNewStudent(@RequestBody Student student) {
    studentService.addNewStudent(student);
  }

  @DeleteMapping(path="deleteStudent/{studentID}")
  public void deleteStudent(@PathVariable("studentID") Long studentID) {
    studentService.deleteStudent(studentID);
  }

  @PutMapping(path="updateStudent/{studentID}")
  public void updateStudent(@PathVariable("studentID") Long studentID, @RequestParam(required = false) String name, @RequestParam(required = false) String email) {
    studentService.updateStudent(studentID, name, email);
  }
}
