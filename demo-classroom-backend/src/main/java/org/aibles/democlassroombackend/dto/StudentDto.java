package org.aibles.democlassroombackend.dto;

import java.io.Serializable;
import lombok.Data;

@Data
public class StudentDto implements Serializable {
  private Long studentId;
  private String fullName;
  private Integer dob;
  private Integer sex;
  private String address;
  private Long classroomId;
}
