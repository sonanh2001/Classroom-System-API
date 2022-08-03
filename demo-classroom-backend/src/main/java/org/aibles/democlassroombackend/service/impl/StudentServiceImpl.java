package org.aibles.democlassroombackend.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.aibles.democlassroombackend.dto.StudentDto;
import org.aibles.democlassroombackend.entity.Student;
import org.aibles.democlassroombackend.exception.ResourceNotFoundException;
import org.aibles.democlassroombackend.mapper.StudentMapper;
import org.aibles.democlassroombackend.repository.StudentRepository;
import org.aibles.democlassroombackend.service.StudentService;

@Slf4j
public class StudentServiceImpl implements StudentService {
  private final StudentMapper studentMapper;
  private final StudentRepository studentRepository;

  public StudentServiceImpl(StudentRepository studentRepository, StudentMapper studentMapper) {
    this.studentMapper = studentMapper;
    this.studentRepository = studentRepository;
  }

  @Override
  public StudentDto addStudent(StudentDto studentDto) {
    log.info("add student have info: {}", studentDto);
    Student student = new Student();
    student = studentRepository.save(studentMapper.mapToEntity(student, studentDto));
    return studentMapper.mapToDto(student);
  }

  @Override
  public List<StudentDto> getStudents() {
    log.info("get all students");
    return studentRepository.findAll().stream().map(studentMapper::mapToDto).collect(Collectors.toList());
  }

  @Override
  public StudentDto getStudent(long id) {
    log.info("get student have id: {}", id);
    Student student = studentRepository
        .findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Can't find student"));
    return studentMapper.mapToDto(student);
  }

  @Override
  public StudentDto updateStudent(StudentDto studentDto, long id) {
    log.info("update student at id: {} have info: {}", id, studentDto);
    Student student =
        studentRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Can't find student"));
    student = studentRepository.save(studentMapper.mapToEntity(student, studentDto));
    return studentMapper.mapToDto(student);
  }

  @Override
  public void deleteStudent(long id) {
    log.info("delete student have id: {}", id);
    Student student =
        studentRepository
            .findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Can't find student"));
    studentRepository.delete(student);
  }
}
