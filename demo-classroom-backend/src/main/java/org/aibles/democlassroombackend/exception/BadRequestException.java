package org.aibles.democlassroombackend.exception;

public class BadRequestException extends RuntimeException{
  private final String message;;
  public BadRequestException(String message) {
    this.message = message;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
