package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Course;

// repository to use and modifiy the data from the parameter "course" and the "Id"
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}