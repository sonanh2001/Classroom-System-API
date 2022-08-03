package org.aibles.democlassroombackend.service;

import java.util.List;
import org.aibles.democlassroombackend.dto.StudentDto;
import org.aibles.democlassroombackend.entity.Student;

public interface StudentService {
  StudentDto addStudent(StudentDto studentDto);
  List<StudentDto> getStudents();
  StudentDto getStudent(long id);
  StudentDto updateStudent(StudentDto studentDto, long id);
  void deleteStudent(long id);
}
