package org.aibles.democlassroombackend.exception;

public class ResourceNotFoundException extends RuntimeException{
  private final String message;
  public ResourceNotFoundException(String message) {
    super();
    this.message = message;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
