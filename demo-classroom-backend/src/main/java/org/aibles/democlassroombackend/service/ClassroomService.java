package org.aibles.democlassroombackend.service;

import java.util.List;
import org.aibles.democlassroombackend.dto.ClassroomDto;
import org.aibles.democlassroombackend.entity.Classroom;

public interface ClassroomService {
  ClassroomDto createClassroom(ClassroomDto classroomDto);
  ClassroomDto getClassroom(long id);
  List<ClassroomDto> getClassrooms();
  ClassroomDto updateClassroom(ClassroomDto classroomDto,long id);
  void deleteClassroom(long id);
}
