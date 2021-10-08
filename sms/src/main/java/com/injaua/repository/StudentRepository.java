package com.injaua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.injaua.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
//nothing here, all methods are henritanced from jpaRepository
}
