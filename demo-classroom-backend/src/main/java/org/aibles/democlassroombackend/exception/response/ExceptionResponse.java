package org.aibles.democlassroombackend.exception.response;

import java.time.Instant;
import lombok.Data;

@Data
public class ExceptionResponse {
  private String error;
  private String message;
  private Instant timeStamp;
}
