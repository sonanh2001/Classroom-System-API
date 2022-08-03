package org.aibles.democlassroombackend.exception.handle;

import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democlassroombackend.exception.ResourceNotFoundException;
import org.aibles.democlassroombackend.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
@Slf4j
public class ResourceNotFoundExceptionHandle {
  @ExceptionHandler(ResourceNotFoundException.class)
  public ExceptionResponse resourceNotFoundHandle(ResourceNotFoundException e) {
    log.info("Exception: error: {}, message: {}", HttpStatus.NOT_FOUND.value(), e.getMessage());
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setError("Not Found!!!");
    exceptionResponse.setMessage(e.getMessage());
    exceptionResponse.setTimeStamp(Instant.now());
    return exceptionResponse;
  }
}
