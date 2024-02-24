package net.practice.springboot.repository;

import org.springframework.stereotype.Repository;
import net.practice.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
	
}


