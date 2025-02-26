package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Student;

// repository to use and modifiy the data from the parameter "Student" and the "Id"
@Repository
public interface studentRepository extends JpaRepository<Student, Long> {
    
}