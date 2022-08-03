package org.aibles.democlassroombackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democlassroombackend.dto.ClassroomDto;
import org.aibles.democlassroombackend.entity.Classroom;
import org.aibles.democlassroombackend.exception.ResourceNotFoundException;
import org.aibles.democlassroombackend.mapper.ClassroomMapper;
import org.aibles.democlassroombackend.repository.ClassroomRepository;
import org.aibles.democlassroombackend.service.ClassroomService;

@Slf4j
public class ClassroomServiceImpl implements ClassroomService {

  private final ClassroomRepository classroomRepository;
  private final ClassroomMapper classroomMapper;

  public ClassroomServiceImpl(
      ClassroomRepository classroomRepository, ClassroomMapper classroomMapper) {
    this.classroomRepository = classroomRepository;
    this.classroomMapper = classroomMapper;
  }

  @Override
  public ClassroomDto createClassroom(ClassroomDto classroomDto) {
    log.info("create a classroom have info: {}", classroomDto);
    Classroom classroom = new Classroom();
    classroomMapper.mapToEntity(classroom, classroomDto);
    classroom = classroomRepository.save(classroom);
    return classroomMapper.mapToDto(classroom);
  }

  @Override
  public ClassroomDto getClassroom(long id) {
    log.info("get classroom have id: {}", id);
    Classroom classroom = classroomRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Can't find classroom"));
    return classroomMapper.mapToDto(classroom);
  }

  @Override
  public List<ClassroomDto> getClassrooms() {
    log.info("get all classrooms");
    return classroomRepository.findAll().stream().
        map((classroomMapper::mapToDto)).collect(
        Collectors.toList());
  }

  @Override
  public ClassroomDto updateClassroom(ClassroomDto classroomDto, long id) {
    log.info("update classroom at id: {} have info: {}", id, classroomDto);
    Classroom classroom =
        classroomRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Can't find classroom"));
    classroom = classroomRepository.save(classroomMapper.mapToEntity(classroom, classroomDto));
    return classroomMapper.mapToDto(classroom);
  }

  @Override
  public void deleteClassroom(long id) {
    log.info("delete classroom have id: {}", id);
    Classroom classroom =
        classroomRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Can't find classroom"));
    classroomRepository.delete(classroom);
  }
}
