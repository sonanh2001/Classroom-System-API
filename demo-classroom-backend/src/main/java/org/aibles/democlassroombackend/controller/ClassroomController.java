package org.aibles.democlassroombackend.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democlassroombackend.dto.ClassroomDto;
import org.aibles.democlassroombackend.entity.Classroom;
import org.aibles.democlassroombackend.exception.BadRequestException;
import org.aibles.democlassroombackend.service.ClassroomService;
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
@RequestMapping("api/v1/classrooms")
@Slf4j
public class ClassroomController {
  private final ClassroomService classroomService;

  public ClassroomController(ClassroomService classroomService) {
    this.classroomService = classroomService;
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<ClassroomDto> getClassrooms() {
    log.info("get all classrooms");
    return classroomService.getClassrooms();
  }

  @GetMapping(path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  public ClassroomDto getClassroom(@PathVariable("id") long id) {
    log.info("get classroom have id: {}", id);
    return classroomService.getClassroom(id);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Transactional
  public ClassroomDto createClassroom(
      @RequestBody @Valid ClassroomDto classroomDto, BindingResult bindingResult) {
    log.info("create a classroom have info: {}", classroomDto);
    if (bindingResult.hasErrors()) {
      throw new BadRequestException("Invalid Input!!!");
    }
    return classroomService.createClassroom(classroomDto);
  }

  @PutMapping(path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public ClassroomDto updateClassroom(
      @PathVariable("id") long id,
      @RequestBody @Valid ClassroomDto classroomDto,
      BindingResult bindingResult) {
    log.info("update classroom at id: {} have info: {}", id, classroomDto);
    if (bindingResult.hasErrors()) {
      throw new BadRequestException("Invalid Input!!!");
    }
    return classroomService.updateClassroom(classroomDto, id);
  }

  @DeleteMapping(path = "{id}")
  @ResponseStatus(HttpStatus.OK)
  @Transactional
  public String deleteClassroom(@PathVariable("id") long id) {
    log.info("delete student have id: {}", id);
    classroomService.deleteClassroom(id);
    return "Delete classroom successfully!!!";
  }
}
