package org.aibles.democlassroombackend.dto;

import java.io.Serializable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class StudentDto implements Serializable {
  private Long studentId;
  @NotNull
  @Size(min = 2)
  @Size(max = 255)
  private String fullName;
  @NotNull
  private Integer dob;
  @NotNull
  private Integer sex;
  @NotNull
  @Size(min = 2)
  @Size(max = 255)
  private String address;
  @NotNull
  private Long classroomId;
}
