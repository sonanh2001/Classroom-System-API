package org.aibles.democlassroombackend.repository;

import org.aibles.democlassroombackend.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
