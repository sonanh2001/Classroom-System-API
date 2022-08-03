package org.aibles.democlassroombackend.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "classroom")
public class Classroom {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long classroomId;
  @Column(nullable = false, length = 128)
  private String name;
  @Column(nullable = false, length = 100)
  private String department;
  @Column(nullable = false, length = 100)
  private String trainingSystem;
  @Column(nullable = false)
  private Integer studentsNumber;
  @OneToMany(mappedBy = "classroom", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
  private Set<Student> students = new HashSet<>();
}

