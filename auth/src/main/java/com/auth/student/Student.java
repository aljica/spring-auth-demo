package com.auth.student;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Student {
  @Id
  @SequenceGenerator(
    name = "student_sequence",
    sequenceName = "student_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student_sequence"
  )

  private Long id;
  private String name;
  private String email;
  private LocalDate dob;
  @Transient
  private Integer age;

  public Student() {

  }

  public Student(Long id, String name, String email, LocalDate dob) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.dob = dob;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public Integer getAge() {
    return Period.between(this.dob, LocalDate.now()).getYears();
  }

  public void setDob(LocalDate dob) {
    this.dob = dob;
  }

  public LocalDate getDob() {
    return dob;
  }

  @Override
  public String toString() {
    return "Student{" +
      "id=" + id +
      ", name=" + name +
      ", email=" + email +
      ", dob=" + dob +
      ", age=" + age +
    "}";
  }
}
