package com.auth.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

  @Mock
  private StudentRepository studentRepository;
  private StudentService underTest;

  @BeforeEach
  void setUp() {
    underTest = new StudentService(studentRepository);
  }
  
  @Test
  void canGetAllStudents() {
    // when
    underTest.getStudents();

    // then
    verify(studentRepository).findAll();
  }

  @Test
  void canAddStudent() {
    // given
    String email = "jamila@gmail.com";
    Student student = new Student(
      4L, "Jamila", email, LocalDate.of(2002, Month.MARCH, 7)
    );

    // when
    underTest.addNewStudent(student);

    // then
    ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);

    // Capture the student object that gets sent to studentRepo.save().
    verify(studentRepository).save(studentArgumentCaptor.capture());

    Student capturedStudent = studentArgumentCaptor.getValue();
    assertEquals(capturedStudent, student);
  }

  @Test
  void willThrowWhenEmailIsTaken() {
    // given
    String email = "jamila@gmail.com";
    Student student = new Student(
      4L, "Jamila", email, LocalDate.of(2002, Month.MARCH, 7)
    );

    
    when(studentRepository.findStudentByEmail(student.getEmail())).thenReturn(Optional.of(student));

    // when
    // then
    assertThrows(IllegalStateException.class, () -> underTest.addNewStudent(student), "email taken");

    verify(studentRepository, never()).save(any()); // Verify that no student gets saved after exception is raised.
  }

  @Test
  @Disabled
  void deleteStudent() {

  }
}
