package org.aibles.democlassroombackend.mapper;

import org.aibles.democlassroombackend.dto.ClassroomDto;
import org.aibles.democlassroombackend.entity.Classroom;
import org.modelmapper.ModelMapper;


public class ClassroomMapper {
  private final ModelMapper modelMapper;

  public ClassroomMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public ClassroomDto mapToDto(Classroom classroom) {
    return modelMapper.map(classroom, ClassroomDto.class);
  }
  public Classroom mapToEntity(Classroom classroom, ClassroomDto classroomDto) {
    modelMapper.map(classroomDto, classroom);
    return classroom;
  }
}
