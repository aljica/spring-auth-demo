package com.auth.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

  @Query(value = "SELECT * FROM Student s WHERE s.email=?1", nativeQuery = true)
  Optional<Student> findStudentByEmail(String email);

  @Query(value = "" + 
    "SELECT CASE WHEN COUNT(*) > 0 THEN " +
    "TRUE ELSE FALSE END " +
    "FROM student s " + 
    "WHERE s.email = ?1", nativeQuery = true
  )
  Boolean selectExistsEmail(String email);

}