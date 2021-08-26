package com.auth.student;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class StudentRepositoryTest {
  
  @Autowired
  private StudentRepository underTest;

  @Test
  void itShouldCheckIfStudentExistsByEmail() {
    // given
    String email = "jamila@gmail.com";
    Student student = new Student(
      4L, "Jamila", email, LocalDate.of(2002, Month.MARCH, 7)
    );
    underTest.save(student);

    // when
    boolean exists = underTest.selectExistsEmail(email);

    // then
    assertTrue(exists);
  }

  @Test
  void studentEmailShouldNotExist() {
    // given
    String email = "jamila@gmail.com";

    // when
    boolean exists = underTest.selectExistsEmail(email);

    // then
    assertFalse(exists);
  }

  @AfterEach
  void tearDown() {
    underTest.deleteAll();
  }
}
