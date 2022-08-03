package org.aibles.democlassroombackend.configuration;

import org.aibles.democlassroombackend.mapper.ClassroomMapper;
import org.aibles.democlassroombackend.mapper.StudentMapper;
import org.aibles.democlassroombackend.repository.ClassroomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfiguration {
  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

  @Bean
  public ClassroomMapper classroomMapper(ModelMapper modelMapper) {
    return new ClassroomMapper(modelMapper);
  }

  @Bean
  public StudentMapper studentMapper(ModelMapper modelMapper,
      ClassroomRepository classroomRepository) {
    return new StudentMapper(modelMapper, classroomRepository);
  }
}
