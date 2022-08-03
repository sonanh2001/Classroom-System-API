package org.aibles.democlassroombackend.mapper;

import lombok.extern.slf4j.Slf4j;
import org.aibles.democlassroombackend.dto.StudentDto;
import org.aibles.democlassroombackend.entity.Classroom;
import org.aibles.democlassroombackend.entity.Student;
import org.aibles.democlassroombackend.exception.BadRequestException;
import org.aibles.democlassroombackend.repository.ClassroomRepository;
import org.modelmapper.ModelMapper;

public class StudentMapper {
  private final ModelMapper modelMapper;
  private final ClassroomRepository classroomRepository;

  public StudentMapper(ModelMapper modelMapper, ClassroomRepository classroomRepository) {
    this.modelMapper = modelMapper;
    this.classroomRepository = classroomRepository;
  }

  public StudentDto mapToDto(Student student) {
    StudentDto studentDto = modelMapper.map(student, StudentDto.class);
    studentDto.setClassroomId(student.getClassroom().getClassroomId());
    return studentDto;
  }

  public Student mapToEntity(Student student, StudentDto studentDto) {
    Classroom classroom =
        classroomRepository
            .findById(studentDto.getClassroomId())
            .orElseThrow(() -> new BadRequestException("Classroom is not existed"));
    if(classroom.getStudents().size() == classroom.getStudentsNumber()) {
      throw new BadRequestException("Classroom is full");
    }
    student.setClassroom(classroom);
    modelMapper.map(studentDto, student);
    return student;
  }
}
