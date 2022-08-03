package org.aibles.democlassroombackend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "student")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studentId;
  @Column(nullable = false, length = 255)
  private String fullName;
  @Column(nullable = false)
  private Integer dob;
  @Column(nullable = false)
  private Integer sex;
  @Column(nullable = false, length = 255)
  private String address;
  @ManyToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "classroom_id", nullable = false)
  private Classroom classroom;
}
