package org.aibles.democlassroombackend.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class ClassroomDto implements Serializable {

  private Long classroomId;
  private String name;
  private String department;
  private String trainingSystem;
  private Integer studentsNumber;
}
