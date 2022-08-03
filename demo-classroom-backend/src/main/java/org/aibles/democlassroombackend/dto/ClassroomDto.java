package org.aibles.democlassroombackend.dto;

import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
public class ClassroomDto implements Serializable {

  private Long classroomId;
  @NotNull
  @Size(min = 2)
  @Size(max = 128)
  private String name;
  @NotNull
  @Size(min = 2)
  @Size(max = 100)
  private String department;
  @NotNull
  @Size(min = 2)
  @Size(max = 100)
  private String trainingSystem;
  @NotNull
  @Max(value = 100)
  @Min(value = 10)
  private Integer studentsNumber;
}
