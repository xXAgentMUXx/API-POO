package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Enrollment;

// repository to use and modifiy the data from the parameter "Enrollment" and the "Id"
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    
}