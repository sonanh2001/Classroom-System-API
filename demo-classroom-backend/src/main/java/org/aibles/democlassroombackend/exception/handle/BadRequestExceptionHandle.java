package org.aibles.democlassroombackend.exception.handle;

import java.time.Instant;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democlassroombackend.exception.BadRequestException;
import org.aibles.democlassroombackend.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
@Slf4j
public class BadRequestExceptionHandle {
  @ExceptionHandler(BadRequestException.class)
  public ExceptionResponse badRequestHandle(BadRequestException e) {
    log.info("Exception: error: {}, message: {}", HttpStatus.BAD_REQUEST.value(), e.getMessage());
    ExceptionResponse exceptionResponse = new ExceptionResponse();
    exceptionResponse.setError("Bad Request!!!");
    exceptionResponse.setMessage(e.getMessage());
    exceptionResponse.setTimeStamp(Instant.now());
    return exceptionResponse;
  }
}
