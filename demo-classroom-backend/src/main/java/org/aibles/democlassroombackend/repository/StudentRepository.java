package org.aibles.democlassroombackend.repository;

import org.aibles.democlassroombackend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
