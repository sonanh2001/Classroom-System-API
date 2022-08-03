package org.aibles.democlassroombackend.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democlassroombackend.dto.StudentDto;
import org.aibles.democlassroombackend.exception.BadRequestException;
import org.aibles.democlassroombackend.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/students")
@Slf4j
public class StudentController {
  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<StudentDto> getStudents() {
    log.info("get all students");
    return studentService.getStudents();
  }

  @GetMapping(path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentDto getStudent(@PathVariable("id") long id) {
    log.info("get student have id: {}", id);
    return studentService.getStudent(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Transactional
  public StudentDto addStudent(
      @RequestBody @Valid StudentDto studentDto, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      throw new BadRequestException("Invalid Input!!!");
    }
    return studentService.addStudent(studentDto);
  }

  @PutMapping(path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public StudentDto updateStudent(
      @PathVariable("id") long id,
      @RequestBody @Valid StudentDto studentDto,
      BindingResult bindingResult) {
    log.info("update student at id: {} have info: {}", id, studentDto);
    if(bindingResult.hasErrors()) {
      throw new BadRequestException("Invalid Input!!!");
    }

    return studentService.updateStudent(studentDto, id);
  }

  @DeleteMapping(path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public String deleteStudent(@PathVariable("id") long id) {
    log.info("delete student have id: {}", id);
    studentService.deleteStudent(id);
    return "Delete student successfully";
  }
}
