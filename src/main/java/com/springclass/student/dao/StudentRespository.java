package com.springclass.student.dao;

import com.springclass.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends JpaRepository<Student, Integer> {


}
