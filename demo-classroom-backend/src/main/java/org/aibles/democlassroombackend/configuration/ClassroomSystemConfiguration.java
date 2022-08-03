package org.aibles.democlassroombackend.configuration;

import org.aibles.democlassroombackend.mapper.ClassroomMapper;
import org.aibles.democlassroombackend.mapper.StudentMapper;
import org.aibles.democlassroombackend.repository.ClassroomRepository;
import org.aibles.democlassroombackend.repository.StudentRepository;
import org.aibles.democlassroombackend.service.ClassroomService;
import org.aibles.democlassroombackend.service.StudentService;
import org.aibles.democlassroombackend.service.impl.ClassroomServiceImpl;
import org.aibles.democlassroombackend.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"org.aibles.democlassroombackend.repository"})
@ComponentScan(basePackages = {"org.aibles.democlassroombackend.repository"})
public class ClassroomSystemConfiguration {
  @Bean
  public ClassroomService classroomService(
      ClassroomRepository classroomRepository, ClassroomMapper classroomMapper) {
    return new ClassroomServiceImpl(classroomRepository, classroomMapper);
  }

  @Bean
  public StudentService studentService(
      StudentRepository studentRepository, StudentMapper studentMapper) {
    return new StudentServiceImpl(studentRepository, studentMapper);
  }
}
